# APILogin

# Entidades
## Usuario (UserEntity)
### El usuario tiene los siguientes campos:

- Id: Identificador único generado automáticamente.
- username: Nombre del usuario.
- email: Dirección de correo electrónico.
- password: Contraseña del usuario.

  
## Sesión (SessionEntity)
### La sesión tiene los siguientes campos:

- Id: Identificador único generado automáticamente.
- startTime: Fecha y hora de inicio de la sesión.
- endTime: Fecha y hora de finalización de la sesión.
- userEntity: Usuario asociado a la sesión mediante una relación OneToOne.

## Validaciones
Email
La validación del email se realiza utilizando expresiones regulares para garantizar que el email tenga un formato correcto.

## Formato del Email:
- Patrón: ^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.-]?[a-zA-Z0-9]+)*\.[a-zA-Z]{2,4}$
## Condiciones:
- Debe comenzar con uno o más caracteres alfanuméricos.
- Puede contener un guion bajo (_) o un punto (.), pero no de forma consecutiva.
- Debe contener un símbolo @.
- Después del @, puede tener un guion (-) o un punto (.), pero no de forma consecutiva.
- El dominio debe contener entre 2 y 4 caracteres alfabéticos.
Contraseña
- La validación de la contraseña se realiza también mediante expresiones regulares para asegurarse de que cumpla con un conjunto específico de requisitos de seguridad.

## Formato de la Contraseña:
Patrón: ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,32}$
## Condiciones:
- Debe contener al menos 8 caracteres y no más de 32.
- Debe incluir al menos una letra minúscula (a-z).
- Debe incluir al menos una letra mayúscula (A-Z).
- Debe incluir al menos un dígito (0-9).
- Debe incluir al menos uno de los siguientes caracteres especiales: @$!%*?&.

## Funcionalidades
### Registro de Usuario
### Para registrar un nuevo usuario, se debe enviar una solicitud POST con un cuerpo JSON que contenga los campos name, email y password a la siguiente URL: 

{
    "name": "Honorius di Gesús",
    "email": "jaramilloortega@gmail.com",
    "password": "abc123*A"
}

## Inicio de Sesión
### GET /login/{email}/{password}El inicio de sesión se realiza enviando el correo electrónico y la contraseña en la URL. Ejemplo:
localhost:8081/login/correo@gmail.com/abc123*A


## Excepciones

### La API maneja las siguientes excepciones:

### InvalidEmailFormatException
- **Código de error:** 100
- **Valor:** `EMAIL_FORMAT_INVALID`
- **Descripción:** Cuando el formato del correo electrónico no es válido.

### InvalidPasswordUserException
- **Código de error:** 101
- **Valor:** `PASSWORD_WEAK`
- **Descripción:** Cuando la contraseña no cumple con las validaciones.

### InvalidUserNameException
- **Código de error:** 102
- **Valor:** `NAME_CANNOT_BE_BLANK`
- **Descripción:** Cuando el nombre de usuario está en blanco.

### UserNotFoundException
- **Código de error:** 103
- **Valor:** `USER_NOT_FOUND`
- **Descripción:** Cuando el usuario no se encuentra registrado.

Cada excepción devuelve un código de error y un mensaje descriptivo.


