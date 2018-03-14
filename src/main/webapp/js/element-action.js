
//События
var Action = function() {
    return {
        //Событие сохранения элемента
        save : function(innerElement) {
            if (innerElement.hasClass("saved")) {
                return false;
            }
            var currentElement = innerElement.closest(".action-element");
            var result = ajaxSend.save(createJson(innerElement));
            result.success(function(id) {
                innerElement.addClass("saved");
                currentElement.find(".id").val(id);
            });
            result.error(function(error) {
                currentElement.find(".error-message").append(error.responseText);
            });
            currentElement.find(".name").focus();
        },
        //Событие удаления элемента
        del : function(innerElement) {
            var element = innerElement.closest(".action-element");
            var id = element.find(".id").val();
            //Если элемент до этого не был сохранен (id существует)
            if (id.length > 0) {
                var result = ajaxSend.del(id);
                result.success(function(id) {
                    element.remove();
                });
                result.error(function(error) {
                    element.find(".error-message").append(error.responseText);
                });
            } else {
                element.remove();
            }
        },
        //Событие добавления элемента
        create : function(innerElement) {
            var div = createNewElement();
            innerElement.closest(".action-element").after(div);
        }
    };
};
var action = Action();

//Создаем новый элемент
var createNewElement = function() {
    var div = $("#element-hidden .action-element").clone();
    //Вешаем события на созданный элемент
    bindActions(div);
    return div;
};

//Вешает события на элемент
var bindActions = function(element) {
    //Функция для изменения статуса на не сохраненный
    var changeOnNotSaved = function(object) {
        var currentElement = object.closest(".action-element");
        currentElement.find(".save-btn").removeClass("saved");
        currentElement.find(".error").empty();
    };
    //Добавляем статус клавиши на "Сохраненный"
    element.find(".save-btn").addClass("saved");
    //Вешаем событие на изменение текста: изменить статус клавиши на не сохраненный
    element.find("input").keydown(function() {
        changeOnNotSaved($(this));
    });
    //Вешаем событие на изменение выпадающего списка: изменить статус клавиши на не сохраненный
    element.find("select").click(function() {
        changeOnNotSaved($(this));
    });
    element.find(".save-btn").click(function() {
        action.save($(this));
        return false;
    });
    element.find(".delete-btn").click(function() {
        action.del($(this));
        return false;
    });
    element.find(".new-btn").click(function() {
        action.create($(this));
        return false;
    });
};

$(document).ready(function() {
    var container = $("#page-content");
  //Если справочник пуст - создаем новый элемент
    if ($.trim(container.html().trim().length) == 0) {
        container.append(createNewElement());
    } else {
        //Вешаем события на элементы
        bindActions(container);
    }
});