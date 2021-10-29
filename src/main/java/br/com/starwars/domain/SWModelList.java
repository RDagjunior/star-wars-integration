package br.com.starwars.domain;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SWModelList<T> implements Serializable {

    public int count;
    public String next;
    public String previous;
    public List<T> results;

    public boolean hasMore() {
        return (next != null && !next.isEmpty());
    }
}