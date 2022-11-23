package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{

    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();
    RegistrationCompletePage registrationCompletePage = new RegistrationCompletePage();
    ProductEmailAFriend productEmailAFriend = new ProductEmailAFriend();
    AppleMacBookPro appleMacBookPro = new AppleMacBookPro();
    FacebookPage facebookPage = new FacebookPage();
    NewReleaseComment newReleaseComment = new NewReleaseComment();
    CurrencyVerification currencyVerification = new CurrencyVerification();

    @Test
      public void VerifyIfUserIsAbleToRegister(){

        homePage.clickOnRegistrationButton();
        registrationPage.verifyIfUserIsOnRegisterPage();
        registrationPage.enterRegistrationInfo();
        registrationCompletePage.verifyIfRegistrationIsCompleted();

      }

      @Test
      public void referAFriendAppleMacBook(){

          homePage.clickOnRegistrationButton();
          registrationPage.verifyIfUserIsOnRegisterPage();
          registrationPage.enterRegistrationInfo();
          registrationCompletePage.verifyIfRegistrationIsCompleted();
          homePage.clickOnAppleMacBookPro();
          appleMacBookPro.clickOnEmailAFriend();
          productEmailAFriend.emailAFriend();
      }

      @Test
      public void verifyIfAlertIsPresentAndAccept(){

        homePage.voteButtonToVerify_AcceptAlert();
      }

      @Test
      public void clickOnFacebookPageVerifyAndToMainPage(){

        facebookPage.switchTodWindow();

      }
      @Test
      public void verifyMyCommentIsShowingAtTheBottom(){

        newReleaseComment.commentOnNewRelease();

      }
      @Test
      public void verifyProductShowingCurrectCurrency(){

          currencyVerification.dollarEuroVerification();
      }
//



}
