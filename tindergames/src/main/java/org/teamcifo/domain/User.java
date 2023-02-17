package org.teamcifo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private String name, lastName, password, email;
    private String userId;
    private GamesCollection userGameCollection;
    private List<GamePlay> gamePlays;



}
