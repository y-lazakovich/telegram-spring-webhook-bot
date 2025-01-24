package io.starter.telegram.dao;

import java.util.Objects;

import io.starter.telegram.constants.League;
import io.starter.telegram.entity.LeagueEntity;
import io.starter.telegram.entity.UserEntity;
import io.starter.telegram.repo.LeagueRepository;
import io.starter.telegram.repo.UserRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.message.MaybeInaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.message.Message;

@Service
public class UserDao {

  private final UserRepository userRepository;
  private final LeagueRepository leagueRepository;

  @Autowired
  public UserDao(UserRepository userRepository,
                 LeagueRepository leagueRepository) {
    this.userRepository = userRepository;
    this.leagueRepository = leagueRepository;
  }

  public void save(UserEntity userEntity) {
    userRepository.save(userEntity);
  }

  public void saveLastMessageId(User user,
                                Message message) {
    UserEntity entity = userRepository.findByUserId(user.getId());
    entity.setLastMessageId(message.getMessageId());
    save(entity);
  }

  public void saveLastMessageId(User user,
                                MaybeInaccessibleMessage message) {
    UserEntity entity = userRepository.findByUserId(user.getId());
    entity.setLastMessageId(message.getMessageId());
    save(entity);
  }

  public void saveLeague(User user,
                         League setting) {
    UserEntity userEntity = userRepository.findByUserId(user.getId());
    LeagueEntity leagueEntity = leagueRepository.findById(setting.id);
    userEntity.setLeagueId(leagueEntity);
    save(userEntity);
  }

  public LeagueEntity readLeague(User user) {
    UserEntity entity = userRepository.findByUserId(user.getId());
    return entity.getLeagueId();
  }

  public int readSkillPage(User user) {
    UserEntity entity = userRepository.findByUserId(user.getId());
    return entity.getSkillPage();
  }

  public void saveSkillPage(User user, int page) {
    UserEntity entity = userRepository.findByUserId(user.getId());
    entity.setSkillPage(page);
    save(entity);
  }

  public void saveWhenNotExist(User user) {
    UserEntity userEntity = userRepository.findByUserId(user.getId());
    LeagueEntity leagueEntity = leagueRepository.findById(9L);
    if (Objects.isNull(userEntity)) {
      userEntity = new UserEntity();
      userEntity.setLeagueId(leagueEntity);
      userEntity.setUserId(user.getId());
      userEntity.setFirstName(user.getFirstName());
      userEntity.setUserName(Objects.requireNonNullElse(user.getUserName(), StringUtils.EMPTY));
      userEntity.setLastName(Objects.requireNonNullElse(user.getLastName(), StringUtils.EMPTY));
      userEntity.setSkillPage(1);
      save(userEntity);
    }
  }
}
