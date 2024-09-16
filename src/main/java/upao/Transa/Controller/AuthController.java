package upao.Transa.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upao.Transa.Service.UserService;
import upao.Transa.dto.request.AuthRequesDTO;
import upao.Transa.dto.request.SignupRequesDTO;
import upao.Transa.dto.response.AuthResponseDTO;
import upao.Transa.dto.response.UserProfileResponseDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    /**
     * Endpoint para iniciar sesión.
     */
    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponseDTO> signIn(@RequestBody AuthRequesDTO authRequestDTO) {
        AuthResponseDTO authResponse = userService.signIn(authRequestDTO);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    /**
     * Endpoint para registrarse.
     */
    @PostMapping("/sign-up")
    public ResponseEntity<UserProfileResponseDTO> register(@RequestBody @Validated SignupRequesDTO signupRequestDTO) {
        UserProfileResponseDTO userProfileResponseDTO = userService.signup(signupRequestDTO);
        return new ResponseEntity<>(userProfileResponseDTO, HttpStatus.CREATED);
    }
}
