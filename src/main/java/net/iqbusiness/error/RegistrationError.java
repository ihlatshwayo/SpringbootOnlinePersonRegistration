package net.iqbusiness.error;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class RegistrationError {
    private int errorCode;
            private String message;
}
