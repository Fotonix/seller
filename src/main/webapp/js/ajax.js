
//Функционал для работы с Ajax
var AjaxSend = function(url) {
    var send = function(data, method) {
        return $.ajax({
            url: url,
            type: method,
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json'
        });
    };
    return {
        save : function(data) {
            return send(data, 'POST');
        },
        del : function(data) {
            return send(data, 'DELETE');
        }
    };
};
