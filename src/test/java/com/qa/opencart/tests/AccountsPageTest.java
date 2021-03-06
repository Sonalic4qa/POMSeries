p
	package com.qa.opencart.tests;

	import java.util.List;
	import com.qa.opencart.base.BaseTest;

	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import com.qa.opencart.utils.Constants;

	public class AccountsPageTest extends BaseTest { //for acc page precond user sh login,so write login crential in base class

		@BeforeClass
		public void accPageSetup() {
			accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		}

		@Test
		public void accPageTitleTest() {
			String title = accPage.getAccPageTitle();
			System.out.println("Acc page title is : " + title);
			Assert.assertEquals(title, Constants.ACC_PAGE_TITLE);
		}

		@Test
		public void accPageLogoutLinkTest() {
			Assert.assertTrue(accPage.isLogoutLinkExist());
		}

		@Test
		public void accPageSearchTest() {
			Assert.assertTrue(accPage.isSeachFieldExist());
		}
		
		@Test
		public void accPageSecHeaderTest() {
			List<String> actSecList = accPage.getAccountSecList();
			System.out.println(actSecList);
			Assert.assertEquals(actSecList, Constants.EXP_ACCOUNTS_SECTIONS_LIST);
		}

	}

