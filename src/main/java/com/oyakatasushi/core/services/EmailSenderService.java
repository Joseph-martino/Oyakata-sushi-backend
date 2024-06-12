package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Reservation;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSenderService {

    public void sendConfirmationEmail(Reservation reservation) {

        System.out.println("ici c'est emailsender");
        // Configuration des paramètres SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp-mail.outlook.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Informations d'identification SMTP
        final String username = "******";
        final String password = "****";

        System.out.println(("encore l'emailSender"));
        // Création de la session SMTP
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        System.out.println("session: " + session);

        System.out.println("mail expediteur est: " + username + " mail destinataire est: " + reservation.getEmail());
        try {
            // Création du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your_email@example.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reservation.getEmail()));
            message.setSubject("Confirmation de réservation");

            // Contenu de l'e-mail
            String emailContent = "Merci pour votre réservation ! Voici les détails de votre réservation :\n\n"
                    + "Nom : " + reservation.getFamilyName() + "\n"
                    + "Prénom : " + reservation.getFirstName() + "\n"
                    + "Email : " + reservation.getEmail() + "\n"
                    + "Nombre de personnes : " + reservation.getNumberOfPersons() + "\n"
                    + "Date de réservation : " + reservation.getReservationDate() + "\n";

            // Envoyer le contenu du message
            message.setText(emailContent);

            // Envoyer l'e-mail
            Transport.send(message);

            System.out.println("E-mail de confirmation envoyé avec succès !");
        } catch (MessagingException e) {
            System.err.println("Erreur lors de l'envoi de l'e-mail de confirmation : " + e.getMessage());
        }
    }
}
