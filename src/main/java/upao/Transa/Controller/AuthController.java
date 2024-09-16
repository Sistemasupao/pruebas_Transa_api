package upao.Transa.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upao.Transa.Service.EmailService;
import upao.Transa.Security.TokenProvider;
import upao.Transa.Service.UserService;
import upao.Transa.domain.Entity.Usuario;
import upao.Transa.dto.request.AuthRequesDTO;
import upao.Transa.dto.request.SignupRequesDTO;
import upao.Transa.dto.response.AuthResponseDTO;
import upao.Transa.dto.response.UserProfileResponseDTO;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final TokenProvider tokenProvider;
    private final EmailService emailService;

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

    @PostMapping("/send-email-link")
    public ResponseEntity<?> sendEmailLink(@RequestBody Map<String, String> request) {
        String email = request.get("email");

        String token = tokenProvider.createEmailVerificationToken(new Usuario(email));

        String verificationLink = "http://localhost:4200/verify-email?token=" + token;


        emailService.sendVerificationEmail(email, verificationLink);

        return ResponseEntity.ok("Enlace de acceso enviado al correo.");
    }

    @PostMapping("/verify-email")
    public ResponseEntity<AuthResponseDTO> verifyEmail(@RequestBody Map<String, String> request) {
        String token = request.get("token");

        if (tokenProvider.validateToken(token)) {
            String email = tokenProvider.getEmailFromToken(token);

            String jwtToken = tokenProvider.createAccessToken(new UsernamePasswordAuthenticationToken(email, null));


            UserProfileResponseDTO userProfile = userService.findByCorreo(email);


            return ResponseEntity.ok(new AuthResponseDTO(jwtToken, userProfile));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");


        String token = tokenProvider.createPasswordResetToken(email);


        String resetLink = "http://tu-frontend.com/reset-password?token=" + token;


        emailService.sendPasswordResetEmail(email, resetLink);

        return ResponseEntity.ok("Enlace de recuperación enviado al correo.");
    }
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        String newPassword = request.get("newPassword");

        if (tokenProvider.validateToken(token)) {
            String email = tokenProvider.getEmailFromToken(token);
            userService.resetPassword(email, newPassword);
            return ResponseEntity.ok("Contraseña restablecida con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido.");
        }
    }


}
