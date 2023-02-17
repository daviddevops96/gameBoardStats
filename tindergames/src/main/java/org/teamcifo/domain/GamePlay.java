package org.teamcifo.domain;


import java.util.List;

import lombok.Data;
@Data
class GamePlay {
    private String gameId;
    private long time;
    private String winner;
    private String gameplayId;
    private List<String> playersId;
}
