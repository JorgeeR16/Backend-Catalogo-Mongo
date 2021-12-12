package co.usa.catalogo.revista.Modelos;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {
    @Id
    private Integer id;

    private String identification;

    private String name;

    private String address;

    private String cellPhone;

    private String email;

    private String password;

    private String zone;

    private String type;

}
