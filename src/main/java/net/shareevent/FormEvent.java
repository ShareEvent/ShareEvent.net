package net.shareevent;

import java.time.LocalDate;
import java.time.LocalTime;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;

public class FormEvent extends FormLayout {

    private TextField title;

    private DatePicker startDate;
    private TimePicker startTime;

    private DatePicker endDate;
    private TimePicker endTime;

    private NumberField duration;

    private ComboBox<TypeDuration> typeDuration;

    private TextArea description;

    /**
     */
    public FormEvent() {
        generateTitleField();
        generateStartDateField();
        generateStartTimeField();
        generateEndTimeField();
        generateEndDateField();
        generateDurationField();
        generateDescriptionField();
    }

    private void generateTitleField() {
        title = new TextField("Title");
        title.setRequired(true);
    }

    private void generateStartDateField() {
        startDate = new DatePicker("Starting date", LocalDate.now());
        startDate.setRequired(true);
    }

    private void generateStartTimeField() {
        startTime = new TimePicker("Starting time", LocalTime.now());
        startTime.setRequired(true);
    }
    
    private void generateEndDateField() {
        endDate = new DatePicker("Ending date", LocalDate.now());
        endDate.setRequired(true);
    }
    
    private void generateEndTimeField() {
        endTime = new TimePicker("Ending time", LocalTime.now());
        endTime.setRequired(true);
    }

    private void generateDurationField() {
        duration = new NumberField("Duration");
        typeDuration = new ComboBox<TypeDuration>();
        //TODO Il ne doit pas pouvoir mettre de nombre négatif
    }

    private void generateDescriptionField() {
        description = new TextArea("Description");
    }

}