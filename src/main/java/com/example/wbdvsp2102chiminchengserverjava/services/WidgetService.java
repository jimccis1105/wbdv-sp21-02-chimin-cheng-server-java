package com.example.wbdvsp2102chiminchengserverjava.services;
import com.example.wbdvsp2102chiminchengserverjava.models.Widget;
import com.example.wbdvsp2102chiminchengserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
    @Autowired
    WidgetRepository repository;
    private List<Widget> widgets;
    private static final String TOPIC_ID = "60589f8488285c00170782ca";
    private static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, "
            + "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et "
            + "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation "
            + "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure "
            + "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla "
            + "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia "
            + "deserunt mollit anim id est laborum.";
    public WidgetService()
    {
        widgets = new ArrayList<Widget>();
        Widget testingHeading = new Widget(789l, TOPIC_ID, "HEADING", 1, "Heading not being edited (default)");
        Widget testingParagraph = new Widget(89l, TOPIC_ID, "PARAGRAPH", 1, LOREM_IPSUM);
        widgets.add(testingHeading);
        widgets.add(testingParagraph);
    }


    public Widget createWidgetForTopic(String topicId, Widget widget) {
        widget.setTopicId(topicId);
        return repository.save(widget);
//        widget.setId((new Date()).getTime());
//        widgets.add(widget);
//        return widget;
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        return repository.findWidgetsForTopic(tid);
//        List<Widget> ws = new ArrayList<Widget>();
//        for(Widget w: widgets) {
//            if(w.getTopicId().equals(tid)) {
//                ws.add(w);
//            }
//        }
//        return ws;
    }

    public Integer updateWidget(Long id, Widget widget) {
        Widget originalWidget = repository.findById(id).get();

        // TODO: copy all the other fields testing for null
        if(widget.getHeight() != null){
            originalWidget.setHeight(widget.getHeight());
        }
        if(widget.getOrdered() != null){
            originalWidget.setOrdered(widget.getOrdered());
        }
        if(widget.getSize() != null){
            originalWidget.setSize(widget.getSize());
        }
        if(widget.getSrc() != null){
            originalWidget.setSrc(widget.getSrc());
        }
        if(widget.getText() != null){
            originalWidget.setText(widget.getText());
        }
        if(widget.getType() != null){
            originalWidget.setType(widget.getType());
        }
        if(widget.getWidth() != null){
            originalWidget.setWidth(widget.getWidth());
        }
        repository.save(originalWidget);
        return 1;
//        for(int i=0; i<widgets.size(); i++) {
//            if(widgets.get(i).getId().equals(id)) {
//                widgets.set(i, widget);
//                return 1;
//            }
//        }
//        return -1;
    }

    public Integer deleteWidget(Long id) {
        repository.deleteById(id);
        return 1;
//        int index = -1;
//        for(int i=0; i<widgets.size(); i++) {
//            if(widgets.get(i).getId().equals(id)) {
//                index = i;
//                widgets.remove(index);
//                return 1;
//            }
//        }
//        return -1;
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) repository.findAll();
//        return widgets;
    }

    public Widget findWidgetById(Long id){
        return repository.findById(id).get();
//        for(int i=0; i<widgets.size(); i++) {
//            if(widgets.get(i).getId().equals(id)) {
//                return widgets.get(i);
//            }
//        }
//        return null;
    }
}