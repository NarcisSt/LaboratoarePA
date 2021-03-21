package Optional.Commands;

import Optional.BaseItem;
import Optional.Main;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ReportCommand implements Command {
    private List<BaseItem> items;

    @SneakyThrows
    @Override
    public void execute() {
        this.createTemplate();
    }

    @SneakyThrows
    private void createTemplate() {
        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\Narcis\\IdeaProjects\\LaboratoarePA\\Lab5\\src\\main\\resources\\"));
        Template template = configuration.getTemplate("template.ftl");

        OutputStream outputStream = new FileOutputStream("C:\\Users\\Narcis\\IdeaProjects\\LaboratoarePA\\Lab5\\src\\main\\resources\\output.html");
        Writer writer = new OutputStreamWriter(outputStream);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("items", items);

        template.process(model, writer);
    }
}