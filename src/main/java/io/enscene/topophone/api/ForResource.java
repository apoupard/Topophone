package io.enscene.topophone.api;

@java.lang.annotation.Retention(value=java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface ForResource {
    Class<? extends ResourceModel> value();
}
