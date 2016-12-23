package io.enscene.topophone.dao;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.io.Files;

import io.enscene.topophone.api.ForResource;
import io.enscene.topophone.api.ResourceModel;

public abstract class AbstractJsonDao<T extends ResourceModel> extends AstractHardCoded<T> {

    final Logger logger = LoggerFactory.getLogger(getClass());

    private final ObjectMapper objectMapper = new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS).registerModule(new GuavaModule());

    void init(Map<String, T> database) {
        ForResource forResource = checkNotNull(this.getClass().getAnnotation(ForResource.class),
                "Dao must be annotated with " + ForResource.class.getName());
        String name = forResource.value().getSimpleName().toLowerCase();
        URL place = getClass().getClassLoader().getResource("data/"+name);
        try {
            File folder = new File(place.toURI());
            Files.fileTreeTraverser().children(folder).forEach(file -> loadFile(database, forResource, file));
        } catch (URISyntaxException e) {
            logger.error("Error loading json for resource [{}] in {}", name, place, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void loadFile(Map<String, T> database, ForResource forResource, File file) {
        try {
            T obj = (T) objectMapper.readValue(file, forResource.value());
            database.put(Files.getNameWithoutExtension(file.getName()), obj);
        } catch (IOException e) {
            logger.error("Error loading json for resource [{}] in {}",  file.getName(), file.getPath(), e);
        }
    }

}
