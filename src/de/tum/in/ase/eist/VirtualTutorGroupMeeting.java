package de.tum.in.ase.eist;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VirtualTutorGroupMeeting extends TutorGroupMeeting {
	private final URL url;

	public VirtualTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, URL url) {
		super(timeSlot, tutorGroup, skillToPractice);
		this.url = url;
	}

	public URL getUrl() {
		return url;
	}

	@Override
	public void sayWelcome(Student tutor) {
		tutor.say("Welcome to the virtual tutor meeting");
		tutor.say("Thank you for joining using " + url.toString() + " today.");
		tutor.say("Please turn on your cameras");
	}

	@Override
	public void sayThankYou(Student tutor) {
		tutor.say("Thank you that you have participated using the " + url + " today.");
	}
}
