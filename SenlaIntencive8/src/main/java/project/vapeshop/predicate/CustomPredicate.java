package project.vapeshop.predicate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomPredicate {
    private Object value;

    private String nameField;

    private TypeFunctionForSql functionForSql;
}
