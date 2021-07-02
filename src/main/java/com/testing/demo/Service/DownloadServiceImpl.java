package com.testing.demo.Service;
import com.testing.demo.Model.Request.DownloadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
@Service
public class DownloadServiceImpl implements DownloadService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public DownloadCategory createDownloadCategory(DownloadCategory downloadCategory) {
        //CREATE NEW DOWNLOAD CATEGORY.
        DownloadCategory category = new DownloadCategory();
        category.setDownloadHeader(downloadCategory.getDownloadHeader());
        category.setDownloadDescription(downloadCategory.getDownloadDescription());
        category.setType(downloadCategory.getType());
        category.setLink(downloadCategory.getLink());
        mongoTemplate.insert(category);
        return category;
    }

    @Override
    public String deleteDownloadCategory(String type) {
        mongoTemplate.remove(new Query(where("type").is(type)), DownloadCategory.class);
        return "Download category id is " + type;
    }

    @Override
    public List<DownloadCategory> getAllDownloadCategories() {
        return mongoTemplate.findAll(DownloadCategory.class);
    }

}
