package pl.tweeter.Tweeter.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.tweeter.Tweeter.domain.entity.Role;
import pl.tweeter.Tweeter.domain.entity.User;
import pl.tweeter.Tweeter.domain.repositories.RoleRepository;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;
import pl.tweeter.Tweeter.dtos.RegistrationDataDTO;
import pl.tweeter.Tweeter.services.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public RegistrationServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public void register(RegistrationDataDTO registrationDataDTO) {
        ModelMapper modelMapper = new ModelMapper ();
        User user = modelMapper.map ( registrationDataDTO, User.class );
        user.setActive ( Boolean.TRUE );
        String encodedPassword = passwordEncoder.encode ( registrationDataDTO.getPassword () );
        user.setPassword ( encodedPassword );

        Role role = roleRepository.getByName ( "ROLE_USER" );
        user.getRoles ().add ( role );
        userRepository.save ( user );


    }
}
