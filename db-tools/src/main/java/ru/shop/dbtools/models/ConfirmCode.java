package ru.shop.dbtools.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shop.dbtools.models.user.User;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="confirm_code")
public class ConfirmCode {

    @Id
    private UUID confirmCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Action action;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "user_id", nullable = false, insertable=false, updatable=false)
    private UUID userId;

    public enum Action {
        RESTORE_PASSWORD,
        REGISTRATION
    }


}
