package com.company.factories;

import com.company.model.Appointment;

public class AppointmentFactory {

    public static Appointment createAppointment() {
        return new Appointment();
    }

}
