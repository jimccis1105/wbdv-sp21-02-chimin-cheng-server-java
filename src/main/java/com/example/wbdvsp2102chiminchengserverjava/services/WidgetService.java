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

    public Widget createWidgetForTopic(String topicId, Widget widget) {
        widget.setTopicId(topicId);
        return repository.save(widget);
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        return repository.findWidgetsForTopic(tid);
    }

    public Integer updateWidget(Long id, Widget widget) {
        Widget originalWidget = repository.findById(id).get();

        if(originalWidget == null){
            return 0;
        }
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
    }

    public Integer deleteWidget(Long id) {
        if(id == null){
            return 0;
        }
        repository.deleteById(id);
        return 1;
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) repository.findAll();
    }

    public Widget findWidgetById(Long id){
        return repository.findById(id).get();
    }
}