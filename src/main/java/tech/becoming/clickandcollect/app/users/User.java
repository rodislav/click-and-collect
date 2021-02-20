package tech.becoming.clickandcollect.app.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USERS", schema = "clickandcollect")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String role;

}
