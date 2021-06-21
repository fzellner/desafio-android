# PicPay - Desafio Android

<img src="https://github.com/mobilepicpay/desafio-android/blob/master/desafio-picpay.gif" width="300"/>

Um dos desafios de qualquer time de desenvolvimento é lidar com código legado e no PicPay isso não é diferente. Um dos objetivos de trazer os melhores desenvolvedores do Brasil é atacar o problema.
Para isso, essa etapa do processo consiste numa proposta de solução para o desafio abaixo e você pode escolher a melhor forma de resolvê-lo, de acordo com sua comodidade e disponibilidade de tempo:
- Resolver o desafio previamente, e explicar sua abordagem no momento da entrevista.
- Resolver o desafio durante a entrevista, fazendo um pair programming interativo com os nossos devs, guiando o desenvolvimento.

Com o passar do tempo identificamos alguns problemas que impedem esse aplicativo de escalar e acarretam problemas de experiência do usuário. A partir disso elaboramos a seguinte lista de requisitos que devem ser cumpridos ao melhorar nossa arquitetura:

- Em mudanças de configuração o aplicativo perde o estado da tela. Gostaríamos que o mesmo fosse mantido.
- Nossos relatórios de crash têm mostrado alguns crashes relacionados a campos que não deveriam ser nulos sendo nulos e gerenciamento de lifecycle. Gostaríamos que fossem corrigidos.
- Gostaríamos de cachear os dados retornados pelo servidor.
- Haverá mudanças na lógica de negócios e gostaríamos que a arquitetura reaja bem a isso.
- Haverá mudanças na lógica de apresentação. Gostaríamos que a arquitetura reaja bem a isso.
- Com um grande número de desenvolvedores e uma quantidade grande de mudanças ocorrendo testes automatizados são essenciais.
  - Gostaríamos de ter testes unitários testando nossa lógica de apresentação, negócios e dados independentemente, visto que tanto a escrita quanto execução dos mesmos são rápidas.
  - Por outro lado, testes unitários rodam em um ambiente de execução diferenciado e são menos fiéis ao dia-a-dia de nossos usuários, então testes instrumentados também são importantes.

Boa sorte! =)



TODOS:
- [x] Migracao para gradle kts;
- [x] Remocao de dependencias nao utilizadas;
- [x] Implementacao de injecao de dependencias;
- [x] Separacao de camadas;
- [x] Separacao de responsabilidades;
- [x] Implementacao navigation;
- [x] Implementacao para guardar estado da view;
- [x] Implementacao de cache;
- [x] Implementacao de testes unitários
- [x] Refatorar nome de package de contacts para users
- [ ] Implementacao de testes de view

### Abordagem utilizada:

Para aplicar uma solução que possa ser escalável e de fácil manutenção,
me utilizei da arquiterura MVVM com separação por feature, com conceitos de SOLID, clean code e Screaming architure


Tecnologia, arquiterura e conceitos utilizados:

 * Kotlin
 * Gradle kts
 * SOLID
 * Screaming Architeture
 * Flow
 * MVVM
 * Jetpack navigation
 * Room

A aplicação foi dívidida em 4 camadas:

 - app: camada principal para iniciar a aplicação e navegar entre a feature ou demais features.
 - data: camada com a responsabilidade única de buscar os dados remotamente e salvar os dados no banco local.
 - common: camada onde podemos compartilhar funcionalidades e resources por entre os módulos
 - users: camada responsável pela funcionalidade de listagem de usuários






