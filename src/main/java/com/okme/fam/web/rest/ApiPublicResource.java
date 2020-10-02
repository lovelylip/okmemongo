package com.okme.fam.web.rest;

import com.google.common.base.Strings;
import com.okme.fam.repository.UserRepository;
import com.okme.fam.security.jwt.TokenProvider;
import com.okme.fam.service.MailService;
import com.okme.fam.service.UserService;
import com.okme.fam.service.dto.UserDTO;
import io.github.jhipster.web.util.PaginationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/public")
public class ApiPublicResource {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private final UserService userService;

    private final TokenProvider tokenProvider;

    public ApiPublicResource(UserService userService, TokenProvider tokenProvider) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/findUserByEmail")
    public ResponseEntity<UserDTO> findUserByEmail(@RequestBody  UserDTO userDTO) {
        List<UserDTO> listUsers = userService.findUserByEmail(userDTO.getEmail());
        if(!listUsers.isEmpty()){
            return new ResponseEntity<UserDTO>(listUsers.get(0), HttpStatus.OK);
        }
        return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.OK);
    }

    @PostMapping("/signLogout")
    public void ssoLogout(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException, ServletException, IOException {
        String ticket = null;
        String logoutRequest = request.getParameter("logoutRequest");
        if(logoutRequest.contains("<samlp:SessionIndex>")){
            String[] splitTmp = logoutRequest.split("<samlp:SessionIndex>");
            if(splitTmp.length > 1){
                ticket = splitTmp[1].replaceAll("</samlp:SessionIndex></samlp:LogoutRequest>", "");
            }
        }
        if(!Strings.isNullOrEmpty(ticket)) {
            List<UserDTO> listUsers = userService.findUserByTicket(ticket);
            String jwt = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for(int i = 0; i < cookies.length; i++){
                    Cookie cookieItem = cookies[i];
                    if(cookieItem.getName().equals(AUTHORIZATION_HEADER)){
                        jwt = cookieItem.getValue();
                        break;
                    }
                }
            }
            for(UserDTO userDTO : listUsers){
                if(!Strings.isNullOrEmpty(jwt) && !Strings.isNullOrEmpty(userDTO.getJwt()) && jwt.equals(userDTO.getJwt())) {
                    Cookie cookie = new Cookie(AUTHORIZATION_HEADER, null); // Not necessary, but saves bandwidth.
                    cookie.setPath("/");
                    cookie.setHttpOnly(true);
                    cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
                    response.addCookie(cookie);
                }
            }
        }
        System.out.println(ticket);
    }
}
