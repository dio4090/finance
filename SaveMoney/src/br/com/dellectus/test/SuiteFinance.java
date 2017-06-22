package br.com.dellectus.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestCliente.class,
  TestFornecedor.class,
  TestLogin.class
})

public class SuiteFinance {

}
