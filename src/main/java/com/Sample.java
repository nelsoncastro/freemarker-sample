package com;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Sample {

    public static void main(String[] args) throws IOException, TemplateException {

        /* You should do this ONLY ONCE in the whole application life-cycle: */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("./src/main/resources/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        /* You usually do these for MULTIPLE TIMES in the application life-cycle: */

        Map<String, Object> root = new HashMap<>();
        root.put("user", "Big Joe");
        root.put("title", "Our latest product:");

        root.put("from", "nelsoncastro.developer@gmail.com");
        root.put("body", "Lista de produtos para sua alegria.");

        Product latest = new Product();
        latest.setUrl("products/greenmouse.html");
        latest.setName("green mouse");

        root.put("latestProduct", latest);

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("template2.ftl");

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);

        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.

//        try (Writer fileWriter = new FileWriter(new File("output.html"))){
//            temp.process(root, fileWriter);
//        }

    }
}
