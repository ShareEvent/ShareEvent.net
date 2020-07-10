package net.shareevent.gestionevent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
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

    private IntegerField duration;

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

        add(title);
        inSingleLine(title);
        add(startDate, startTime);
        add(endDate, endTime);
        add(duration, typeDuration, endTime);
        add(description);
        inSingleLine(description);
    }

    private void inSingleLine(Component formItem) {
        formItem.getElement().setAttribute("colspan", "2");
    }

    private void generateTitleField() {
        title = new TextField("Title");
        title.setRequired(true);
    }

    private void generateStartDateField() {
        startDate = new DatePicker("Start date", LocalDate.now());
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
        duration = new IntegerField("Duration");
        typeDuration = new ComboBox<>("", TypeDuration.values());
        duration.addValueChangeListener(event -> {
            if (event.isFromClient()) {
                LocalDateTime time = LocalTime
                        .of(((typeDuration.getValue() == TypeDuration.HOUR) ? duration.getValue() : 0),
                                ((typeDuration.getValue() == TypeDuration.MINUTE) ? duration.getValue() : 0),
                                ((typeDuration.getValue() == TypeDuration.SECOND) ? duration.getValue() : 0))
                        .atDate(startDate.getValue()).plusHours(startTime.getValue().getHour())
                        .plusMinutes(startTime.getValue().getMinute())
                        .plusDays((typeDuration.getValue() == TypeDuration.DAY) ? duration.getValue() : 0);

                endDate.setValue(time.toLocalDate());
                endTime.setValue(time.toLocalTime());
            }
        });
        // TODO Il ne doit pas pouvoir mettre de nombre négatif
    }

    private void generateDescriptionField() {
        description = new TextArea("Description");
    }

}