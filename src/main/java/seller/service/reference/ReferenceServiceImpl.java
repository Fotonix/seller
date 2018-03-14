package seller.service.reference;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seller.dao.reference.ProducerDao;
import seller.dao.reference.ProductDao;
import seller.dao.reference.ProductGroupDao;
import seller.dao.reference.SectionDao;
import seller.domain.reference.Producer;
import seller.domain.reference.Product;
import seller.domain.reference.ProductGroup;
import seller.domain.reference.Section;
import seller.service.BaseService;
import seller.util.StringUtil;

/**
 * Реализация интерфейса {@link ReferenceService}
 *
 * @author Aleksei_Zabezhinsky
 */
@Service
public class ReferenceServiceImpl extends BaseService implements ReferenceService {

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductGroupDao productGroupDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SectionDao sectionDao;

    @Autowired
    private ProducerDao producerDao;

    @Override
    public ProductGroup getProductGroup(Integer id) {
        return productGroupDao.read(id);
    }

    @Override
    public void saveProductGroup(ProductGroup entity) {
        entity.setName(StringUtil.normalize(entity.getName()));
        if (entity.getId() == null) {
            productGroupDao.create(entity);
        } else {
            productGroupDao.update(entity);
        }
    }

    @Override
    public void deleteProductGroup(Integer id) {
        productGroupDao.delete(id);
    }

    @Override
    public List<ProductGroup> getProductGroups() {
        return productGroupDao.findAll();
    }

    @Override
    public Product getProduct(Integer id) {
        return productDao.read(id);
    }

    @Override
    public void saveProduct(Product entity) {
        entity.setName(StringUtil.normalize(entity.getName()));
        if (entity.getId() == null) {
            productDao.create(entity);
        } else {
            productDao.update(entity);
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.findAll();
    }

    @Override
    public Section getSection(Integer id) {
        return sectionDao.read(id);
    }

    @Override
    public void saveSection(Section entity) {
        entity.setName(StringUtil.normalize(entity.getName()));
        if (entity.getId() == null) {
            sectionDao.create(entity);
        } else {
            sectionDao.update(entity);
        }
    }

    @Override
    public void deleteSection(Integer id) {
        sectionDao.delete(id);
    }

    @Override
    public List<Section> getSections() {
        return sectionDao.findAll();
    }

    @Override
    public Producer getProducer(Integer id) {
        return producerDao.read(id);
    }

    @Override
    public void saveProducer(Producer entity) {
        entity.setName(StringUtil.normalize(entity.getName()));
        if (entity.getId() == null) {
            producerDao.create(entity);
        } else {
            producerDao.update(entity);
        }
    }

    @Override
    public void deleteProducer(Integer id) {
        producerDao.delete(id);
    }

    @Override
    public List<Producer> getProducers() {
        return producerDao.findAll();
    }

}
