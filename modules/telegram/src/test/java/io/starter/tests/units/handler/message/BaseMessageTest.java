package io.starter.tests.units.handler.message;

import io.starter.telegram.cash.CallbackCash;
import io.starter.telegram.cash.MessageCash;
import io.starter.telegram.dao.UserDao;
import io.starter.telegram.service.CallbackAnswerService;
import io.starter.telegram.service.MessageAnswerService;
import io.starter.tests.BaseTest;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.testng.annotations.BeforeClass;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public abstract class BaseMessageTest extends BaseTest {

  protected final CallbackAnswerService callbackAnswerService = mock(CallbackAnswerService.class);
  protected final UserDao userDao = mock(UserDao.class);
  protected final Message message = mock(Message.class);
  protected final Update update = mock(Update.class);
  protected final User user = mock(User.class);

  protected final MessageAnswerService messageAnswerService = spy(MessageAnswerService.class);
  protected final CallbackCash callbackCash = spy(CallbackCash.class);
  protected final MessageCash messageCash = spy(MessageCash.class);

  @BeforeClass
  protected void setUp() {
    when(update.hasCallbackQuery()).thenReturn(false);
    when(update.getMessage()).thenReturn(message);
    when(message.getFrom()).thenReturn(user);
    doNothing().when(userDao).saveWhenNotExist(user);
    doNothing().when(userDao).saveLastMessageId(user, message);
  }
}
