package org.teamcifo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class GameStats {
    private double buyPrice;
    private int numTimesPlayed;
    private int numWins;
    private boolean owned;
}
