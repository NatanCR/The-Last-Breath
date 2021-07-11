import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Jogo {
	static String nome_aventureiro;

	//// static int temp_dialog = 60, temp_narrativa = 130, temp_transicao = 20;
	//// //Tempo correto do game
	static int temp_dialog = 60, temp_narrativa = 130, temp_transicao = 20; // Para rodar o jogo sem o delay nas
																		// mensagens, pode mudar o valor destas 3
																		// variáveis para 0;

	public static void main(String[] args) throws Exception {
		Scanner entrada = new Scanner(System.in);

		// Digita("\n Um homem conhecido como Mestre Dos Magos e seu Aprendiz chamado
		// Grannus, viagem a procura de suprimentos para fabricação de novas poções.",
		// TimeUnit.MILLISECONDS, temp_dialog);
		int escolha_menu;

		do {
			Digita("\nVocê está pronto para conhecer o incrível mundo de The Last Breath?", TimeUnit.MILLISECONDS,
					temp_dialog);

			System.out.println("\n[1] - Sim  [2] - Com certeza!  [3] - Não estou preparado...");
			escolha_menu = entrada.nextInt();

			if (escolha_menu == 1 || escolha_menu == 2) {
				Digita("\n Perfeito, fique sabendo que é um caminho sem volta!", TimeUnit.MILLISECONDS, temp_dialog);
				menu();
			} else if (escolha_menu == 3) {
				Digita("\n Não se engane, você não tem muita escolha... Abrace o destino!", TimeUnit.MILLISECONDS,
						temp_dialog);
				menu();
			} else {
				Digita("Escolha uma opção valída!", TimeUnit.MILLISECONDS, temp_dialog);
			}
		} while (escolha_menu != 1 && escolha_menu != 2 && escolha_menu != 3);

	}

//============================================================== MENU DO JOGO ================================================================================================================================
	static void menu() throws Exception {
		Scanner entrada = new Scanner(System.in);

		int escolha_menu;
		do {
			Digita("\n\n..:: THE LAST OF BREATH ::.. \n\n1 - Jogar \n2 - Instruções\n3 - Créditos \n4 - Sair",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println();

			escolha_menu = entrada.nextInt();
			if (escolha_menu == 1) {
				jogo();
			} else if (escolha_menu == 2) {
				instrucoes();
			} else if (escolha_menu == 3) {
				creditos();
			} else if (escolha_menu == 4) {
				System.out.println("Você saiu do jogo!");
				System.exit(0);
			} else {
				System.out.println("\nOpção inválida, digite novamente: ");
			}
		} while (escolha_menu != 1 && escolha_menu != 2 && escolha_menu != 3 && escolha_menu != 4);
	}

//============================================================== INSTRUÇÕES ==============================================================================================================================
	static void instrucoes() throws Exception {
		Scanner entrada = new Scanner(System.in);
		int escolha_menu, temp_narrativa = 80;

		Digita("\n O Jogo baseado no modo RPG Textual é uma troca de mensagens em que o jogador move a trama do ponto de vista do seu personagem atráves de uma pergunta respondida.\r\n\n A cada pergunta respondida o jogo dará opções de caminhos para explorar.\r\n\n Ou seja, Mantenha total atenção na hora de responder.\r\n"
				+ "  ", TimeUnit.MILLISECONDS, temp_narrativa);
		Digita("\n No primeiro desafio você terá 3 tentativas para acertar a resposta, mas se errar todas no próxima terá apenas 2 se você chegar a zero perderá o jogo."
				+ "\n Porém toda vez que você acertar vai recuperar suas tentativas."
				+ "\n Boa sorte!"
				+ "  ", TimeUnit.MILLISECONDS, temp_narrativa);
		
		do {
			System.out.println();
			System.out.println("\n2 - Retornar ao menu");
			escolha_menu = entrada.nextInt();
			if (escolha_menu == 2) {
				menu();
			} else {
				System.out.println("\nOpção inválida, digite novamente: ");
			}
		} while (escolha_menu != 2);
	}

//============================================================== CRÉDITOS =================================================================================================================================
	static void creditos() throws Exception {
		Scanner entrada = new Scanner(System.in);
		int escolha_menu, temp_narrativa = 80;

		Digita("\n\n</> Desenvolvedores </>\n\n-> João Vitor Richard Carlos \n-> Natan Camargo Rodrigues \n-> Rafaela Eduarda Teixeira Silva\n-> Thamyra Fernanda de Godoi ",
				TimeUnit.MILLISECONDS, temp_narrativa);

		do {
			System.out.println();
			System.out.println("\n2 - Retornar ao menu");
			escolha_menu = entrada.nextInt();
			if (escolha_menu == 2) {
				menu();
			} else {
				System.out.println("\nOpção inválida, digite novamente: ");
			}
		} while (escolha_menu != 2);
	}

//============================================================== JOGO ================================================================================================================================
	static void jogo() throws Exception {
		Scanner entrada = new Scanner(System.in);

		Digita("\n Para começarmos, por favor, diga-me o seu nome: ", TimeUnit.MILLISECONDS, temp_dialog);
		System.out.println("\n");
		nome_aventureiro = entrada.next();

		Digita("\n Seja bem-vindo(a), ao intenso mundo de The Last Breath, " + nome_aventureiro + "!",
				TimeUnit.MILLISECONDS, 50);

		Digita("\n\n A partir daqui, você iniciará o jogo...", TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n Gostaria de saber mais sobre a trama no qual você está prestes a entrar ou ir direto para o jogo?",
				TimeUnit.MILLISECONDS, temp_dialog);

		int escolha_menu;

		do {
			System.out.println("\n\n1 - Gostaria de saber mais");
			System.out.println("2 - Iniciar jogo");
			System.out.println("3 - Voltar");
			escolha_menu = entrada.nextInt();

			if (escolha_menu == 1) {
				Digita("\n\n Sinopse: ", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n A história se baseia em uma trama repleta de mistérios e magias, onde você viajará em busca da cura que irá salvar sua irmã de uma maldição lançada por um mago aprendiz. \n Durante esta jornada você irá enfrentar diversos obstáculos e desafios que despertará habilidades ocultas dentro de você.\r\n ",
						TimeUnit.MILLISECONDS, temp_dialog);

				Digita("\n\n" + nome_aventureiro + ", hora de iniciar a aventura!", TimeUnit.MILLISECONDS, temp_dialog);

				capitulo_1();
				capitulo_2();
				capitulo_3(0);
				final_1(0);
				final_2(0);

			} else if (escolha_menu == 3) {
				menu();
			} else if (escolha_menu == 2) {
				Digita("\n\n CAPÍTULO I - A terrível maldição", TimeUnit.MILLISECONDS, temp_dialog);
				capitulo_1();
				capitulo_2();
				capitulo_3(0);
				final_1(0);
				final_2(0);

			} else {
				System.out.println("\n Opção inválida!");
			}
		} while (escolha_menu != 1 || escolha_menu != 2 || escolha_menu != 3);
	}

//================================================================ CAPITULO 1 ==============================================================================================================================

	static void capitulo_1() throws Exception {
		Scanner entrada = new Scanner(System.in);

		int resp;

		Digita("\n\n Um homem conhecido como mestre dos magos e seu aprendiz viagem a procura de suprimentos para fabricação de novas poções. \n\n Durante essa jornada, ao chegar em uma vila vizinha chamada Aghoo, encontram o irmão mais novo dos mestre dos magos! Centrion, que foi corrompido por sua fome de poder e conhecimento ao longo dos anos. ",
				TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n - Mestre dos magos: Grannus, preciso de sua ajuda para levar essas pessoas para um local seguro, EU VOU ENFRENTAR MEU IRMÃO E ACABAR COM ISSO DE UMA VEZ POR TODAS! \n\n - Aprendiz: Entendido mestre, assim que eu conseguir levar todos em segurança volto para te ajudar! [...] Por aqui crianças, vou levá-las para um lugar seguro!",
				TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n - Centrion: Eu precisava de algo para chamar sua atenção! Eu tinha que ter certeza de que você estaria aqui irmão. \n\n - Mestre dos magos: O que você pretende fazer com tudo isso ?\n\n - Centrion: Eu quero tirar de você o que me pertence!!",
				TimeUnit.MILLISECONDS, temp_dialog);

		do {

			Digita("\n\n - Mestre dos magos: [1] Isso é o que veremos! ou [2] Você não é páreo para mim!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp = entrada.nextInt();

			if (resp == 1) {
				Digita("\n\n - Mestre dos magos: Isso é o que veremos!", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n Então, uma batalha intensa é travada entre dois magos poderosos e no meio dos destroços uma criança sozinha e indefesa é vista tentando se esconder para não ser atingida… O Aprendiz volta para tentar ajudar seu mestre.",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;

			} else if (resp == 2) {

				Digita("\n\n - Mestre dos magos: Você não é páreo para mim!", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n Então, uma batalha intensa é travada entre dois magos poderosos e no meio dos destroços uma criança sozinha e indefesa é vista tentando se esconder para não ser atingida... O Aprendiz volta para tentar ajudar seu mestre.",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;

			} else {
				System.out.println("Você não digitou uma resposta valída!");

			}
		} while (resp != 1 || resp != 2);

		Digita("\n\n\n- Mestre dos magos: GRANNUS leve essa criança daqui!! Eu vou terminar essa luta sozinho! \n  CENTRIONNNNN!!!! Eu devia ter acabado com você no passado, mas não tem problema eu acabo com você agora!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Aprendiz: Mestre, lembra daquele feitiço que você me ensinou?", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Mestre dos magos: Você tem certeza que isso vai funcionar? \n  Irei confiar nos seus sentidos, meu jovem aprendiz! \n  TENEBRISSS MORTIS!!!!!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n\n   O tempo se fecha e o poder caí sobre Centrion, o inimigo mesmo derrotado ainda não desistiu da luta e quer vingança...",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n\n - Centrion: Você venceu aqui meu irmão, mas essa batalha ainda não acabou!!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n   Então em seu último suspiro de vida Centrion usou o que lhe restava de magia para lançar um feitiço sobre Grannus, o aprendiz do Mestre dos magos, fazendo com que ele seguisse toda a vontade de Centrion.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Centrion: SEQUITUR VESTIIGIA MEA!!!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Aprendiz: AAAARRGH!!!!!! O que você feeez!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Mestre dos magos: Essa luta acabou! Grannus você está bem ?", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Aprendiz: Estou bem, não se preocupe comigo! Vamos levar essa criança daqui e voltar para casa!",
				TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n\n   Depois de uma dura batalha o Mestre dos magos e seu Aprendiz retornam para casa levando uma criança que perdeu seus pais nos destroços causados em Aghoo.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n\n - Aprendiz: Mestre, o que faremos com essa criança?", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Mestre dos magos: Eu vou levá-lo comigo e cuidar dele, tenho certeza que ele se dará muito bem com meus filhos!",
				TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n - .:: 1 ANOS DEPOIS ::.", TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n\n - Aprendiz: Muito bem estamos quase chegando, aguente firme!", TimeUnit.MILLISECONDS,
				temp_dialog);

		Digita("\n\n\n   Grannus vendo seu mestre enfraquecido aproveita para matá-lo e tomar seus poderes. Consumido pelo ódio lançado no feitiço de Centrion, ele amaldiçoou a amada filha de seu mestre a morrer quando completasse 18 anos de idade.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n   Após a morte de seu pai, o Mestre dos Magos, Solveig o filho mais velho leva seus irmãos para um lugar seguro onde eles pudessem viver. Enquanto isso, Grannus celebra seus novos poderes construindo seu reino em uma terra distante.",
				TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n\n - Solveig: " + nome_aventureiro
				+ " preciso lhe ensinar os conhecimentos que nosso pai tinha, para que um dia você possa se defender sozinho, você entende isso ?",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp1;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Eu quero proteger nossa vila do homem que matou nosso Pai!! ou [2] Eu não sei se conseguirei ser bom como você meu irmão",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp1 = entrada.nextInt();

			if (resp1 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Eu quero proteger nossa vila do homem que matou nosso Pai!!  ",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp1 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Eu não sei se um dia conseguirei ser bom como você meu irmão",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp1 != 1 || resp1 != 2);

		Digita("\n\n - Solveig: Você será excelente " + nome_aventureiro
				+ ", agora chame nossa irmã para que eu possa ensiná-los a como batalhar!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": BRYANNAAAAAAA, ONDE ESTÁ VOCÊ?", TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n - Bryanna: Estou aqui, já estou indo!", TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n\n Durante sua juventude Solveig ensina seus irmãos mais novos a desenvolver habilidades e conhecimentos para que um dia eles pudessem juntos derrotar Grannus e livrar Bryanna de sua maldição.",
				TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n\n CAPÍTULO II - Uma jornada inesperada.", TimeUnit.MILLISECONDS, temp_dialog);

		capitulo_2();
	}

//================================================================ CAPITULO 2 ==============================================================================================================================
	static int capitulo_2() throws Exception {

		Scanner entrada = new Scanner(System.in);

		Digita("\n\n\n Ao completar 17 anos, Bryanna começa a receber sinais de que seu tempo de vida está acabando. Seu meio irmão "
				+ nome_aventureiro
				+ " percebe esses acontecimentos e conta para seu irmão mais velho. \n Solveig desesperado para salvar sua irmã busca soluções em livros antigos de seu pai para que talvez encontre algo que possa ajudá-los enquanto o jogador vai em busca da cura que está com Grannus.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n\n - Solveig: Meu irmão, nós não temos escolha. Você precisa ir atrás do Grannus e descobrir um jeito de curar Bryanna",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Eu irei e trarei a cura junto comigo!! ou [2] Bryanna precisa aguentar por mais tempo.",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp = entrada.nextInt();

			if (resp == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Eu irei e trarei a cura junto comigo!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Bryanna precisa aguentar por mais tempo.",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp != 1 || resp != 2);

		Digita("\n\n - Solveig: Eu estou buscando alguma fórmula ou feitiço nos livros do nosso Pai para tentar retardar o tempo dela para que você consiga achar o Grannus, mas até hoje nada do que eu tentei funcionou...",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Você já sabia que esse dia chegaria, não é mesmo?",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Solveig: Eu cometi erros, meu querido irmão, deveria ter contado sobre essa maldição para vocês, mas não queria que isso mudasse a vida dela e nem a sua!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro
				+ ": Então todos aqueles livros e todos aqueles treinos era pra quando esse dia chegasse...",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Solveig: Sim " + nome_aventureiro + "!! Me perdoe, eu fiz o melhor que pude!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp1;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Você deveria ter nos contado!! ou [2] Você sempre cuidou de nós e eu sou grato por isso!!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp1 = entrada.nextInt();

			if (resp1 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Você deveria ter nos contado!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp1 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Você sempre cuidou de nós e eu sou grato por isso!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp1 != 1 || resp1 != 2);

		int resp2;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Obrigado Solveig! ou [2] Agora é melhor que eu parta antes do anoitecer, será uma longa jornada!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp2 = entrada.nextInt();

			if (resp2 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Obrigado Solveig!", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp2 == 2) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Agora é melhor que eu parta antes do anoitecer, será uma longa jornada!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp2 != 1 || resp2 != 2);

		Digita("\n\n - Solveig: Esperee!!! Leve o Doodou, ele pode ser muito útil, mas tenha paciência, desde que o nosso pai morreu ele se tornou um ranzinza.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Está bem, vamos Doodou!", TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n\n..:: 1º Dia da Jornada ::.. ", TimeUnit.MILLISECONDS, temp_transicao);

		Digita("\n\n\n - Doodou: Pois é vamos ter que salvar sua irmã, ora ora que novidade!", TimeUnit.MILLISECONDS,
				temp_transicao);

		int resp3;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Veja bem como fala da minha irmã Doodou se quiser voltar pra casa vivo! ou [2] Escute aqui, não é só porque você era importante para meu pai que pode falar assim da minha irmã!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp3 = entrada.nextInt();

			if (resp3 == 1) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Veja bem como fala da minha irmã Doodou se quiser voltar pra casa vivo!",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else if (resp3 == 2) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Escute aqui, não é só porque você era importante para meu pai que pode falar assim da minha irmã!",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp3 != 1 || resp3 != 2);

		Digita("\n\n - Doodou: Ei ei calma ai " + nome_aventureiro
				+ "! Eu estava apenas brincando. Mas eu vou ficar quieto, não é uma boa ficar conversando, não chamam essa floresta de Floresta do Enganador atoa!",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp4;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Floresta do Enganador? O que diabos quer dizer com isso. ou [2] Quem é esse tal de Enganador?",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp4 = entrada.nextInt();

			if (resp4 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Floresta do Enganador? O que diabos quer dizer com isso",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else if (resp4 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Quem é esse tal de Enganador?", TimeUnit.MILLISECONDS,
						temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");

			}
		} while (resp4 != 1 || resp4 != 2);

		Digita("\n\n - Doodou: O Enganador vive nessa floresta, e ninguém sabe onde ele vive, você só o encontra quando ele quer ser encontrado ou quando ele quer te matar! Isso aqui vai ser mais perigoso do que você pensa meu jovem, se prepare!",
				TimeUnit.MILLISECONDS, temp_transicao);

		Digita("\n\n - " + nome_aventureiro + ": Então vamos sair daqui logo!", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: Veja o que é aquilo? Parece uma casa ou algum tipo de comércio abandonado.",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp5;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Vamos lá!! Eu não gostei disso, mas podemos encontrar pistas! ou [2] É uma péssima ideia mas acho que devemos ir lá!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp5 = entrada.nextInt();

			if (resp5 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos lá!! Eu não gostei disso, mas podemos encontrar pistas!",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else if (resp5 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": É uma péssima ideia mas acho que devemos ir lá.",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");

			}
		} while (resp5 != 1 || resp5 != 2);

		Digita("\n\n - Doodou: Você que manda " + nome_aventureiro + " mas tenha cuidado não quero morrer hoje.",
				TimeUnit.MILLISECONDS, temp_transicao);

		Digita("\n\n\n TOC-TOC a porta se abre.", TimeUnit.MILLISECONDS, temp_transicao);

		int resp6;
		do {

			Digita("\n\n\n - " + nome_aventureiro
					+ ": [1] Olá, tem alguém aqui? ou [2] EEIII SEJA QUEM FOR É MELHOR SAIR!!!!", TimeUnit.MILLISECONDS,
					temp_transicao);
			System.out.println("\n");
			resp6 = entrada.nextInt();

			if (resp6 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Olá, tem alguém aqui?", TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else if (resp6 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": EEIII SEJA QUEM FOR É MELHOR SAIR!!!!", TimeUnit.MILLISECONDS,
						temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp6 != 1 || resp6 != 2);

		Digita("\n\n - Doodou: Ei para de gritar podemos morrer sabia!?", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Enganador: Vocês realmente não sabem onde se meteram, não é mesmo?"
				+ " Bem-vindos a minha casa, se acomodem, vocês jamais sairão daqui!! HAHAHAHAHAHAHAHA!!!!",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - " + nome_aventureiro + ": O que ?? Quem está aí?", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Enganador: Eu sou aquele que vos chamam de Enganador, mas eu posso ser o seu pior pesadelo!!",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: E o que você quer com a gente espertão?", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Enganador: O que eu quero? Rs Nada! Eu já tenho o que eu preciso, suas vidas!",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp7;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Como ousa, eu ainda não estou morto!! ou [2] Quem vai morrer aqui é você!!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp7 = entrada.nextInt();

			if (resp7 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Como ousa, eu ainda não estou morto!!!", TimeUnit.MILLISECONDS,
						temp_transicao);
				break;
			} else if (resp7 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Quem vai morrer aqui é você!!!", TimeUnit.MILLISECONDS,
						temp_transicao);
				Digita("\n\n - " + nome_aventureiro + ": Sinta o poder da minha espada!!! UAAARRHH!!!!!!",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp7 != 1 || resp7 != 2);

		Digita("\n\n - Enganador: O que você pretende com essa espada em criança! Olha eu gostei da sua coragem, vou te dar uma chance de saírem daqui você só vai precisar decifrar um enigma... Está pronto?",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp8;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Vamos terminar logo com isso! ou [2] Eu aceito o desafio, mas quero uma coisa em troca!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp8 = entrada.nextInt();

			if (resp8 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos terminar logo com isso!", TimeUnit.MILLISECONDS,
						temp_transicao);
				break;
			} else if (resp8 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Eu aceito o desafio, mas quero uma coisa em troca!",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp8 != 1 || resp8 != 2);

		Digita("\n\n - Enganador: Tudo bem vamos lá, você deve me dizer a resposta e só porque eu gostei da sua coragem vou te dar três tentativas!",
				TimeUnit.MILLISECONDS, temp_transicao);

		boolean acertou = false;
		int contador = 0;
		int numTentativas = 3;
		List alternativas = new ArrayList();
		alternativas.add("X1 = 2 e X2 = -5"); // resposta correta
		alternativas.add("X1 = 3 e X2 = -8");
		alternativas.add("X1 = 1 e X2 = 5");
		alternativas.add("X1 = -6 e X2 = 2");
		alternativas.add("X1 = -3 e X2 = -4");

		do {
			Collections.shuffle(alternativas);
			System.out
					.println("\n\n Para desvendar o inigma encontre o valor de f(x) = x² + 3x – 10 para que f(x) = 0.");
			System.out.println("");
			System.out.println("a) " + alternativas.get(0));
			System.out.println("b) " + alternativas.get(1));
			System.out.println("c) " + alternativas.get(2));
			System.out.println("d) " + alternativas.get(3));
			System.out.println("e) " + alternativas.get(4));
			System.out.println("");
			System.out.print("Escolha uma alternativa: ");
			String resposta = entrada.next();
			switch (resposta) {
			case "a":
			case "A":
				if (alternativas.get(0).equals("X1 = 2 e X2 = -5")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;

				} else {
					System.out.println("Resposta incorreta!");
					contador++;

				}
				break;
			case "b":
			case "B":
				if (alternativas.get(1).equals("X1 = 2 e X2 = -5")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;

				} else {
					System.out.println("Resposta incorreta!");
					contador++;

				}
				break;
			case "c":
			case "C":
				if (alternativas.get(2).equals("X1 = 2 e X2 = -5")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;

				} else {
					System.out.println("Resposta incorreta!");
					contador++;

				}
				break;
			case "d":
			case "D":
				if (alternativas.get(3).equals("X1 = 2 e X2 = -5")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;

				} else {
					System.out.println("");
					System.out.println("Resposta incorreta!");
					contador++;

				}
				break;
			case "e":
			case "E":
				if (alternativas.get(4).equals("X1 = 2 e X2 = -5")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;

				} else {
					System.out.println("Resposta incorreta!");
					contador++;

				}
				break;
			default:
				System.out.println("Escolha inválida!");
			}
		} while (!acertou & contador < numTentativas);

		if (acertou) {
			System.err.println("Você acertou com " + contador + " tentativa!");
			Digita("\n\n - " + nome_aventureiro
					+ ": Acabou eu ganhei!!! Agora é sua vez! Eu quero que me diga tudo que sabe sobre o Grannus!",
					TimeUnit.MILLISECONDS, temp_transicao);
			numTentativas = 3;
		} else {
			System.err.println("Você errou " + contador + " vezes seguidas!");
			Digita("\n\n - Doodou: Você não é tão bom assim, mas vou quebrar seu galho!", TimeUnit.MILLISECONDS,
					temp_transicao);
			numTentativas = numTentativas - 1;
		}

		Digita("\n\n - Enganador: Ora ora o que temos aqui, então você é o filho do mago? Não estou surpreso",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - " + nome_aventureiro + ": Não me enrole!! EU QUERO VERDADE!!!!", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - Enganador: Muito bem " + nome_aventureiro + ", a única coisa que eu sei são rumores que ouvi na floresta durante esses meses "
				+ "Tudo que eu ouvi foi que ele fugiu para um reino distante ao norte onde pudesse construir seu império... Olha eu sei que você quer se vingar, mas ele não quer ser encontrado!",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp9;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Eu vou encontrá-lo custe o que custar! ou [2] Não tenho escolha, minha irmã depende disso!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp9 = entrada.nextInt();

			if (resp9 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Eu vou encontrá-lo custe o que custar!", TimeUnit.MILLISECONDS,
						temp_transicao);
				break;
			} else if (resp9 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Não tenho escolha, minha irmã depende disso!",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp9 != 1 || resp9 != 2);

		Digita("\n\n - Enganador: Muito bem Jogador, você parece estar determinado por uma boa causa."
				+ " Vou te ajudá-lo mais uma vez, leve minha espada, ela foi forjada por anões nas Montanhas de Elso, feita de titânio encontrado naquela montanha.",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: Ora ora pra quem queria nos matar até que nos ajudou bastante não é mesmo!",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp10;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Obrigado nobre enganador, eu aceito! ou [2] Eu não confio em você, prefiro continuar com a minha espada.",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp10 = entrada.nextInt();

			if (resp10 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Obrigado nobre Enganador, eu aceito!", TimeUnit.MILLISECONDS,
						temp_transicao);
				break;
			} else if (resp10 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Eu não confio em você, prefiro continuar com a minha espada.",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Enganador: Vamos criança você vai precisar mais do que eu!", TimeUnit.MILLISECONDS,
						temp_transicao);
				Digita("\n\n - Doodou: Pegue " + nome_aventureiro + ", vamos precisar de uma arma nesta longa jornada",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - " + nome_aventureiro + ": Está bem eu aceito a espada, obrigado!", TimeUnit.MILLISECONDS,
						temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp10 != 1 || resp10 != 2);

		Digita("\n\n - Doodou: Okay, fez muito bem em aceitar! vamos embora daqui...", TimeUnit.MILLISECONDS,
				temp_transicao);

		Digita("\n\n\n..:: 2º Dia da Jornada ::.. ", TimeUnit.MILLISECONDS, temp_transicao);

		Digita("\n\n\n - " + nome_aventureiro
				+ ": Então Doodou nós vamos para norte, você lembra o aquele louco disse, não é?",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: Certo meu rapaz, você sabe o que encontraremos ao norte até chegarmos no Grannus, não sabe? Existem animais mágicos que vivem no caminho até a Montanha de Elso como os Hipogrifos.",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp11;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] O que é um Hipogrifo? ou [2] Não quero saber, preciso ir logo para salvar minha irmã!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("");
			resp11 = entrada.nextInt();

			if (resp11 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": O que é um Hipogrifo?", TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Doodou: Hipogrifos são criaturas mágicas que prezam o respeito e a única forma de evitar um ataque mortal desse animal, é mostrando que você tem boas intenções realizando uma reverência. Se o hipogrifo retribuir, é sinal de que você está seguro. Se não... bom você já pode imaginar! ",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else if (resp11 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Não quero saber, preciso ir logo para salvar minha irmã!",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Doodou: Bom, não diga que eu não avisei!", TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp11 != 1 || resp11 != 2);

		Digita("\n\n - " + nome_aventureiro + ": Doodou você parece ser bem inteligente!", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - Doodou: Não é atoa que eu sempre ajudava seu pai.", TimeUnit.MILLISECONDS, temp_transicao);

		int resp12;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] De onde você veio e como aprendeu tanta coisa? ou [2] Você é muito egocêntrico e se acha muito!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp12 = entrada.nextInt();

			if (resp12 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": De onde você veio e como aprendeu tanta coisa?",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Doodou: Eu nasci numa vila de duendes muito antiga chamada Vila de Lovran, antes de você existir muito antes de muita coisa existir, "
						+ "\nnós duendes construímos muitas coisas com os magos e foi assim que conheci seu pai, ele era gênio desde quando o conheci ele queria trazer paz ao mundo através da magia!"
						+ "\n Desde então eu vivi junto de seu pai para que pudéssemos ajudar o mundo a ser algo melhor do que é hoje, mas infelizmente tudo aquilo aconteceu... a morte dele.",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else if (resp12 == 2) {
				Digita("\n\n - Doodou: Egocêntrico é uma palavra muito forte, eu diria que eu sou um duende incrível e que adora desafios novos.",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp12 != 1 || resp12 != 2);

		Digita("\n\n - " + nome_aventureiro
				+ ": Eiiii Doodou, estou vendo a montanha!!! É muito legal saber sobre tudo isso, porém precisamos ir mais rápido!",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: Estou com um mau pressentimento " + nome_aventureiro + "!!", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - " + nome_aventureiro + ": Estou vendo algo se mexendo nas árvores!!", TimeUnit.MILLISECONDS,
				temp_transicao);

		int resp13;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Meu deus o que é isso? ou [2] É melhor essa espada ser bem afiada!", TimeUnit.MILLISECONDS,
					temp_transicao);
			System.out.println("\n");
			resp13 = entrada.nextInt();

			if (resp13 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Meu deus o que é isso?", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp13 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": É melhor essa espada ser bem afiada!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp13 != 1 || resp13 != 2);

		Digita("\n\n - Doodou: Eu não posso acreditar!! ISSO É MESMO O QUE ESTOU PENSANDO!!?", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Doodou que tipo de bicho é esse?", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Isso meu jovem é Hipogrifo!", TimeUnit.MILLISECONDS, temp_dialog);
		System.out.println("                                                                                                                                                     \r\n"
				+ "                                                                                                                        @                             \r\n"
				+ "         .@        @@                                                                                                  @@@ @                          \r\n"
				+ "         &                                                                                                            (@@@@   @                       \r\n"
				+ "         @    .    @                                                                                                 %    ,@@@                        \r\n"
				+ "                   .                                                                                                @   & @ @@                        \r\n"
				+ "              .    &                                #  @                                                        .  @@,.@&@@(@                         \r\n"
				+ "        *            (*                             %  *. @                                                   .@  @@   &     &                        \r\n"
				+ "     @       (                                     & @* @                                                    &@ @@ @ (( @@@@% @                       \r\n"
				+ "       @ .                                           @      (&                                               @ @@*@@@  .@                             \r\n"
				+ "         #% . ,  /     @                      /   @           .   #                                         * .@@    @/@ @@#                          \r\n"
				+ "          * *   @*/ / *                     @  @      .      (.   @@                                   &  @@   @/ @  @.,@@                            \r\n"
				+ "            ,&@     *@ %                    @**           # /    ,                                  #   @ /  @@@   @@ @@ /                            \r\n"
				+ "               @ &        *@           ( &     ,  #%@ #  @@ (       / @                                @%%  @@  @  @@@@                               \r\n"
				+ "                 %@     (@ *          @     @@@&  (*@@ &(   @  @     @                         &    @    #@@&   @ @/@                                 \r\n"
				+ "                /   @@ &/    @        & @   @@,@@@@@@@@@@@@@/@@(  *   %                     @     # @ @# @/  @@@((                                    \r\n"
				+ "                    @@@@/ @ # *             @#     %@@@@@@@@@@/   (   (                  @     @(  %  @.       @(%                                    \r\n"
				+ "                          @    @&                 @@@@&  @@ @@ @       @               @    / /@@(@,     (   %@ ( @                                   \r\n"
				+ "                           @@   ,.              @@@*%@@@#@ @& @/@@                  %    @( @(  @  (@      @@@@ @                                     \r\n"
				+ "                           @@@@@ @@           @@@@@@@ @@%  @. & @     ,           @    @@   @@,/    *@@@@@@@,@ (                                      \r\n"
				+ "                           ,@@@@@* @       @@@ @ @ @/@.#@@    & *              @     @ *@# @@    @      (@@@@@                                        \r\n"
				+ "                             #@@@@@       @@@@&@*& @ @@@    @.       /(     @   *   @    @  * @@@    ##*.@#,                                          \r\n"
				+ "                             @@@@@@@@% *@@@@@@(@@,@ @ . @@#    #     (  *%   #   @@  @@@@@/   *    *@@@ @@@                                           \r\n"
				+ "                              ,@@@@@@@@@@@@@@@@@@ @ % @# & ,( %%   ,@   @ % @@.    %@@@@@   %    @%@@@@  % &                                          \r\n"
				+ "                                @@@@@@@@@@@ @  &@*@@ ,, && %@  @.   %@((    @@@@. ,            @@@@@ @   @                                            \r\n"
				+ "                                  @@@@@@@@@@@@@@,  @  @  @ @@@  %@ % @  @@@@%    @@     @ @,    @@  %@@                                               \r\n"
				+ "                                    @@&@@ @  @@, .@     @.@@@ @.   @ ..@@% @@@   @@@@ @  /@@@@ .  @. @ @.                                             \r\n"
				+ "                                   .@@@ %@@&& @ @@ @@@@@      @@@@# @@  @@. @@@  @   @@ @@@.   @  @.. .           .. &          .@                    \r\n"
				+ "                                   %@@@  (@@@#@  @#  @@      @  @/@@&@ @@ @@ & @@@@@@@@@@ @   @ @& @@@@@@@@@@@@&@@#..@@@@              &@ @@          \r\n"
				+ "                                   @@@@ @@@@@@@@@@@  @      @@@@  @@@ @ .@@.@ , @ @@ #  @     @  @@@@@@@@@@@@@@@  @@. .      ..* .   .*@@.            \r\n"
				+ "                                    @@@@@@@@@@@@@@*     @  @@@@@@ @@@    @@@@@,@@@   #.    @@@@@@@@@@@@@@@@@@@@@@@@@@@@/&           @@@@@@@@@@@@&     \r\n"
				+ "                                    @@@@@@@@@@@@@@*   @@@ @ /@@@@@ @@@(@@   ,@.@ @@,  @ ,@@          @ @@@@@@@@@@@@@@@@    @@  %@@@@@           .@ (  \r\n"
				+ "                                    @@@@@@@@@@@@@@@ @@     @@@@@@(#@@ @%@@  @   @@ @ @@@@@ @    .       @@ @@@@@@@@@@@@@@@@@@ @         @@  @      @@&\r\n"
				+ "                                 @@@@@@@@(@@@@@@@@@@     @@@@@@@@@@@@@@@@ @@@ &@@@@@@@@@@@ @@@@                      @@@@      %               @      \r\n"
				+ "                             @@  @@             @@@    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     @                                                      \r\n"
				+ "        @   @            %@  @@                  @@@  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       @                                                    \r\n"
				+ "      @  @@@   &    @@@. .                      @         .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#       @                                                   \r\n"
				+ "    @@  @@@@@@@      /                        /@ %(        & *       @@@@@@@@@@@@@   @@@@@@@      .                                                   \r\n"
				+ "     @ @@&        @                          @& .@                  %@@@@@@@@@@@@       @@@ @ *       @@@&                                            \r\n"
				+ "   #.  @@          @ @                     @                 @       @@@@@@@@@@@@@         @@@@@@@@@     @           #@                               \r\n"
				+ "    @     @      #/@                   @&@  @ %                          @@@@@@@@@@@                 @@@*          . /                                \r\n"
				+ "                            @@,@     @* @    @                               %@@@@@@@@&                 @@   /@@@ /%     %                            \r\n"
				+ "                            @      %  .@,@  @                              @@@@@@@@/                      @         *                                 \r\n"
				+ "                              ,   @,@  @@@ @                           @@@  @@                             @,     @@#                                 \r\n"
				+ "                                 &       & @                        (@@ @@ @                                @#@  *                                    \r\n"
				+ "                              @          ,*@@                       @@@@    % (@@                            @@@@*@@@,                                \r\n"
				+ "                                       @., #@@                      @#       @ ( /                             @@@ .@@                                \r\n"
				+ "                                       @@@@@                       @@ @.@@@%  #  /                                  @@,                               \r\n"
				+ "                                                                    @@ .@          @                                                                  \r\n"
				+ "                                                                     @@                                                                               \r\n"
				+ "");
		Digita("\n\n - " + nome_aventureiro
				+ ": Ele está me olhando de cima a baixo sem reação o que eu faço Doodou? o que eu faço? Me ajudaaaaaaa...",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Lembra do que eu disse ? Você precisa fazer uma reverência " + nome_aventureiro
				+ " para que eles possam identificar se você tem alguma maldade ou está apenas passando pelo habitat deles!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp14;
		do {

			Digita("\n\n - " + nome_aventureiro + ": [1] Ajoelhar-se e fazer a reverência. ou [2] Pegar a espada.",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp14 = entrada.nextInt();

			if (resp14 == 1) {
				Digita("\n\n - Doodou: Bom garoto, fique tranquilo! Ele está apenas te analisando... mantenha-se calmo!",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else if (resp14 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Nãoooooooooooooooo, não faça isso!!!!!!! ",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Hiprogrífo: GRRRUUUUUUWW!!!!!!", TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Doodou: Tem alguma coisa de errada com ele!", TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp14 != 1 || resp14 != 2);

		Digita("\n\n - " + nome_aventureiro + ": Espera aí tem alguma coisa presa na pata dele!", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - Doodou: É uma corrente, pegue sua espada e arrebente ela!", TimeUnit.MILLISECONDS,
				temp_transicao);

		int resp15;
		do {

			Digita("\n\n - " + nome_aventureiro + ": [1] Arrebentar corrente.", TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			
			
			resp15 = entrada.nextInt();
			if (resp15 == 1) {
				Digita("\n\n TSSSSIIIIIIMMMM!!!!!!", TimeUnit.MILLISECONDS,
						temp_transicao);
				Digita("\n\n - " + nome_aventureiro + ": Essa corrente é mágica, ela não vai quebrar tão facilmente!!",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Doodou: É uma corrente arqueana, para destruir é preciso descobrir a combinação da trava.",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp15 != 1);

		boolean acertou1 = false;
		int contador1 = 0;
		List alternativas1 = new ArrayList();
		alternativas1.add("X1 = 0 e X2 = -3"); // resposta correta
		alternativas1.add("X1 = 1 e X2 = -2");
		alternativas1.add("X1 = 7 e X2 = 4");
		alternativas1.add("X1 = -3 e X2 = 0,5");
		alternativas1.add("X1 = -0,5 e X2 = -9");

		do {
			Collections.shuffle(alternativas1);
			System.out.println("\n\n Para descobrir a combinação encontre o valor de 5x² + 15x = 0 para que f(x) = 0.");
			System.out.println("");
			System.out.println("a) " + alternativas1.get(0));
			System.out.println("b) " + alternativas1.get(1));
			System.out.println("c) " + alternativas1.get(2));
			System.out.println("d) " + alternativas1.get(3));
			System.out.println("e) " + alternativas1.get(4));
			System.out.println("");
			System.out.print("Escolha uma alternativa: ");

			String resposta = entrada.next();
			switch (resposta) {
			case "a":
			case "A":
				if (alternativas1.get(0).equals("X1 = 0 e X2 = -3")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou1 = true;
					contador1++;

				} else {
					System.out.println("Resposta incorreta!");
					contador1++;

				}
				break;
			case "b":
			case "B":
				if (alternativas1.get(1).equals("X1 = 0 e X2 = -3")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou1 = true;
					contador1++;

				} else {
					System.out.println("Resposta incorreta!");
					contador1++;

				}
				break;
			case "c":
			case "C":
				if (alternativas1.get(2).equals("X1 = 0 e X2 = -3")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou1 = true;
					contador1++;

				} else {
					System.out.println("Resposta incorreta!");
					contador1++;

				}
				break;
			case "d":
			case "D":
				if (alternativas1.get(3).equals("X1 = 0 e X2 = -3")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou1 = true;
					contador1++;

				} else {
					System.out.println("Resposta incorreta!");
					contador1++;

				}
				break;
			case "e":
			case "E":
				if (alternativas1.get(4).equals("X1 = 0 e X2 = -3")) {
					System.out.println("");
					System.out.println("Resposta correta!");
					acertou1 = true;
					contador1++;

				} else {
					System.out.println("Resposta incorreta!");
					contador1++;

				}
				break;
			default:
				System.out.println("Escolha inválida!");
			}
		} while (!acertou1 & contador1 < numTentativas);

		if (acertou1) {
			System.err.println("Você acertou com " + contador1 + " tentativa!");
			Digita("\n\n - Doodou: Ótimo " + nome_aventureiro
					+ " você acertou! gire a corrente para o número 0 e depois volte para o -3 para liberar a trava!",
					TimeUnit.MILLISECONDS, temp_transicao);
			numTentativas = 3;

		} else {
			System.err.println("Você errou " + contador1 + " vezes seguidas!");
			numTentativas = numTentativas - 1;

			if (numTentativas == 0) {
				Digita("\n\n GAME OVER!!", TimeUnit.MILLISECONDS, temp_transicao);
				System.exit(0);
			} else {
				Digita("\n\n - Doodou: Ei, espera aí! Acabei de lembrar que tenho algo aqui na mochila que vai resolver isso!!",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Doodou: Isso é uma poção que seu pai me ensinou! Ela irá derreter a corrente e libertá-lo dessa prisão.",
						TimeUnit.MILLISECONDS, temp_transicao);
			}
		}

		Digita("\n\n - " + nome_aventureiro + ": Doooodouuu, ele está vindo pra cima de mim!!", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - Doodou: Ele está agradecendo, acho que ele quer retribuir o favor!", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - " + nome_aventureiro + ": Ele está deixando eu fazer carinho nele.", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - Doodou: " + nome_aventureiro + " tive uma ideia!", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - " + nome_aventureiro + ": Acho que sei o que está pensando...", TimeUnit.MILLISECONDS,
				temp_transicao);

		int resp16;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Usar o Hipogrifo para ir até o topo da montanha. ou [2] Deixe-o em paz, ele está bem cansado! Vamos andando!!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp16 = entrada.nextInt();

			if (resp16 == 1) {
				Digita("\n\n - Doodou: Isso " + nome_aventureiro + " era o que eu estava pensando!",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;

			} else if (resp16 == 2) {
				Digita("\n\n Doodou: Vamos demorar muito tempo para subir... vamos usá-lo para subir a montanha.",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp16 != 1 || resp16 != 2);

		Digita("\n\n - " + nome_aventureiro + ": Calma garoto, estou subindo!", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: HAHAHA EU NUNCA TINHA FEITO ISSO, UHUUUU VAMOS VOAR!!!!", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - " + nome_aventureiro + ": Vamos garoto, leve a gente ao topo da montanha!!",
				TimeUnit.MILLISECONDS, temp_transicao);

		Digita("\n\n -  VUASHHHHHHHHH!!!!!", TimeUnit.MILLISECONDS, temp_transicao);

		Digita("\n\n - Doodou: Olha!!! Estou vendo o castelo dos anões no topo, estamos chegando.",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp17;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Vamos garoto, deixe a gente na frente do castelo! ou [2] Melhor descermos mais afastados, não sabemos quem são eles.",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp17 = entrada.nextInt();

			if (resp17 == 1) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Aaaaa, porque eles estão atirando flechas na gente! calma pessoal!", TimeUnit.MILLISECONDS,
						temp_transicao);
				Digita("\n\n - Doodou: Anões não gostam de hipogrifos, precisamos descer mais afastados e voltar andando",
						TimeUnit.MILLISECONDS, temp_transicao);

				break;
			} else if (resp17 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Ótimo garoto, agora você está livre! Obrigado por nos ajudar!",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Doodou: Obrigado garoto, seja livre!", TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp17 != 1 || resp17 != 2);

		int resp18;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Vamos com cuidado, não confio neles! ou [2] Melhor já pegar a espada!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp18 = entrada.nextInt();

			if (resp18 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos com cuidado, não confio neles!", TimeUnit.MILLISECONDS,
						temp_transicao);

				break;
			} else if (resp18 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Melhor já pegar a espada!", TimeUnit.MILLISECONDS,
						temp_transicao);

				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp18 != 1 || resp18 != 2);

		Digita("\n\n - Rei dos Anões: Quem são vocês? O que querem aqui?", TimeUnit.MILLISECONDS, temp_transicao);

		int resp19;
		do {

			Digita("\n\n - " + nome_aventureiro + ": [1] Eu sou " + nome_aventureiro
					+ " e esse é o Doodou, viemos em paz! Estamos indo em direção ao norte atrás do Grannus! ou [2] Deixe-nos entrar, não queremos problemas!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp19 = entrada.nextInt();

			if (resp19 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Eu sou " + nome_aventureiro
						+ " e esse é o Doodou, viemos em paz! Estamos indo em direção ao norte atrás do Grannus!",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Rei dos Anões: Grannnus? O mago? Jamais diga esse nome novamente!!",
						TimeUnit.MILLISECONDS, temp_transicao);

				int resp20;
				Digita("\n\n - " + nome_aventureiro
						+ ": [1] Grannus matou o meu pai! Estou atrás dele para matá-lo, você sabe onde posso encontrá-lo? [2] Deixe-nos entrar, não queremos problemas!",
						TimeUnit.MILLISECONDS, temp_transicao);
				System.out.println("\n");
				resp20 = entrada.nextInt();

				if (resp20 == 1) {
					Digita("\n\n - " + nome_aventureiro
							+ ": Grannus matou o meu pai!! Estou atrás dele para matá-lo, você sabe onde posso encontrá-lo?",
							TimeUnit.MILLISECONDS, temp_transicao);
					Digita("\n\n - Rei dos Anões: Pode ser que tenhamos o que você procura aventureiro!",
							TimeUnit.MILLISECONDS, temp_transicao);
					break;
				} else if (resp20 == 2) {
					Digita("\n\n - " + nome_aventureiro + ": Porque ficou tão bravo?", TimeUnit.MILLISECONDS,
							temp_transicao);
					Digita("\n\n - Doodou: Ei " + nome_aventureiro + " ele sabe de alguma coisa!",
							TimeUnit.MILLISECONDS, temp_transicao);
					break;
				} else {
					System.out.println("Você não digitou uma resposta valída!");
				}

			} else if (resp19 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Deixe-nos entrar, não queremos problemas!",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - Rei dos Anões: Espero que não precise matá-los e jogar seus corpos montanha abaixo!",
						TimeUnit.MILLISECONDS, temp_transicao);
				Digita("\n\n - " + nome_aventureiro
						+ ": Estamos apenas passando e precisamos de algumas informações, fique tranquilo!",
						TimeUnit.MILLISECONDS, temp_transicao);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp19 != 1 || resp19 != 2);

		Digita("\n\n - Rei dos Anões: Muito bem aventureiros, já está tarde! Fiquem a vontade e amanhã conversamos!",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: " + nome_aventureiro + " está quase anoitecendo! Acho melhor ficarmos por aqui hoje.",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - " + nome_aventureiro
				+ ": Ok, vamos dormir aqui essa noite, mas o tempo está correndo! Logo pela manhã vamos embora!",
				TimeUnit.MILLISECONDS, temp_transicao);

		Digita("\n\n..:: 3º Dia da Jornada ::.. ", TimeUnit.MILLISECONDS, temp_transicao);

		Digita("\n\n - Rei dos Anões: EI SEUS DORMINHOCOS VAMOS LEVANTANDO!", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - " + nome_aventureiro + ": Quanto tempo dormimos Doodou?", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: Não foi tanto assim pra essa cara estar gritando tanto!", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - " + nome_aventureiro + ": Vamos levantar e ver o que vai acontecer hoje...",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: Lá está o Rei vamos até ele!", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Rei dos Anões: Olá, meus jovens passaram bem a noite? Bom eu espero que sim, sentem-se e comam alguma coisa!",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp21;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Ontem quando perguntei sobre Grannus, porque ficou tão bravo? ou [2] Precisamos de informações de onde Grannus está vivendo!",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp21 = entrada.nextInt();

			if (resp21 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Ontem quando perguntei sobre Grannus, porque ficou tão bravo?",
						TimeUnit.MILLISECONDS, temp_transicao);

				break;
			} else if (resp21 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Precisamos de informações de onde Grannus está vivendo!",
						TimeUnit.MILLISECONDS, temp_transicao);

				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp21 != 1 || resp21 != 2);

		Digita("\n\n - Rei dos Anões: Grannus era um bom garoto, sempre nos ajudava quando trabalhava com seu pai! Porém depois que aconteceu tudo aquilo..."
				+ " ele mudou de repente. "
				+ "\nEle veio até a nossa aldeia pedindo ajuda, porém quando chegamos perto ele resolveu matar e destruir 60% de toda nossa aldeia, ficamos sem comida para todos e perdemos entes queridos!"
				+ "\n Com medo viemos morar no topo da montanha, pois aqui foi o único lugar que ele não passou, desde então vivemos aqui, de dia descemos a montanha e pegamos suprimentos e de noite ficamos acolhidos para nós esquentar e sobreviver",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: E você alguma ideia de onde ele possa estar agora?", TimeUnit.MILLISECONDS,
				temp_transicao);
		Digita("\n\n - Rei dos Anões: Posso até te dar algumas informações de Grannus, porém tudo tem seu preço, preciso de um favor de vocês!",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - " + nome_aventureiro + ": Que tipo de favor?", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Rei dos Anões: Nós achamos um baú perdido na floresta, acreditamos que seja um baú perdido dos Elfos, se estivermos certos dentro deve ter muitas joias e ouro que podemos usar para reconstruir nossa história e tirarmos nosso povo da miséria.",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp22;
		do {

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Então você precisa que eu abra isso? ou [2] Tá bom e o que eu tenho com isso?",
					TimeUnit.MILLISECONDS, temp_transicao);
			System.out.println("\n");
			resp22 = entrada.nextInt();

			if (resp22 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Então você precisa que eu abra isso?", TimeUnit.MILLISECONDS,
						temp_transicao);

				break;
			} else if (resp22 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Tá bom e o que eu tenho com isso?", TimeUnit.MILLISECONDS,
						temp_transicao);

				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp22 != 1 || resp22 != 2);

		Digita("\n\n - Rei dos Anões: Se você conseguir abrir o baú eu falo tudo que sei sobre o paradeiro de Grannus... mas já adianto que não vai ser fácil!",
				TimeUnit.MILLISECONDS, temp_transicao);

		boolean acertou2 = false;
		int contador2 = 0;
		List alternativas2 = new ArrayList();
		alternativas2.add("3"); // resposta correta
		alternativas2.add("2,5");
		alternativas2.add("-0,5");
		alternativas2.add("-3");
		alternativas2.add("5");

		do {
			Collections.shuffle(alternativas2);
			System.out.println(
					"\n\n Para que o baú seja aberto o resultado dessa equação deve ser 2 = 2, então determine o valor de x:  (4+ x) - (x+2) = (10 + x) - (11): ");
			System.out.println("");
			System.out.println("a) " + alternativas2.get(0));
			System.out.println("b) " + alternativas2.get(1));
			System.out.println("c) " + alternativas2.get(2));
			System.out.println("d) " + alternativas2.get(3));
			System.out.println("e) " + alternativas2.get(4));
			System.out.println("");
			System.out.print("Escolha uma alternativa: ");
			String resposta = entrada.next();
			switch (resposta) {
			case "a":
			case "A":
				if (alternativas2.get(0).equals("3")) {
					System.out.println("Resposta correta!");
					acertou2 = true;
					contador2++;

				} else {
					System.out.println("Resposta incorreta!");
					contador2++;

				}
				break;
			case "b":
			case "B":
				if (alternativas2.get(1).equals("3")) {
					System.out.println("Resposta correta!");
					acertou2 = true;
					contador2++;

				} else {
					System.out.println("Resposta incorreta!");
					contador2++;

				}
				break;
			case "c":
			case "C":
				if (alternativas2.get(2).equals("3")) {
					System.out.println("Resposta correta!");
					acertou2 = true;
					contador2++;

				} else {
					System.out.println("Resposta incorreta!");
					contador2++;

				}
				break;
			case "d":
			case "D":
				if (alternativas2.get(3).equals("3")) {
					System.out.println("Resposta correta!");
					acertou2 = true;
					contador2++;

				} else {
					System.out.println("Resposta incorreta!");
					contador2++;

				}
				break;
			case "e":
			case "E":
				if (alternativas2.get(4).equals("3")) {
					System.out.println("Resposta correta!");
					acertou2 = true;
					contador2++;

				} else {
					System.out.println("Resposta incorreta!");
					contador2++;

				}
				break;
			default:
				System.out.println("Escolha inválida!");
			}
		} while (!acertou2 & contador2 < numTentativas);

		if (acertou2) {
			System.out.println("Você acertou com " + contador2 + " tentativa!");
			numTentativas = 3;
		} else {
			System.err.println("Você errou " + contador2 + " vezes seguidas!");
			numTentativas = numTentativas - 1;
			if (numTentativas == 0) {
				Digita("\n\n\n GAME OVER!!!", TimeUnit.MILLISECONDS, temp_transicao);
				System.exit(0);
			} else {
				Digita("\n\n - Doodou: Parece ser mais facíl do que isso! Eu tenho uma chave mestra comigo, use-a!! ",
						TimeUnit.MILLISECONDS, temp_transicao);
			}
		}

		Digita("\n\n - " + nome_aventureiro + ": Aqui está o seu baú, espero que encontre o que deseja.",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Rei dos Anões: HAHAHA, MAS EU NÃO ACREDITO!!!!! OLHA COMO ISSO BRILHAAA!!!!!"
				+ " Obrigado meu jovem, você ajudou a salvar o meu povo!", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: Que maravilha né agora vamos desembuchar, o tempo está passando e nós não temos muito!",
				TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Rei dos Anões: Está certo, minha promessa será comprida! Escutem bem, ouvi rumores de que Grannus construiu uma fortaleza no Reino da Morte, isso fica logo após o bosque dos Elfos. "
				+ "\n Mas tomem cuidado, esses Elfos não são lá muito amigáveis, são as criaturas mais gananciosas que já conheci, se os encontrarem não digam nada sobre esse baú por favor eu os imploro!",
				TimeUnit.MILLISECONDS, temp_transicao);

		int resp23;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Muito obrigado pela informação! ou [2] Nós manteremos isso em segredo! Obrigado pela ajuda!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp23 = entrada.nextInt();

			if (resp23 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Muito obrigado pela informação!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp23 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Nós manteremos isso em segredo! Obrigado pela ajuda!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valida!");
			}
		} while (resp23 != 1 || resp23 != 2);

		Digita("\n\n - Rei dos Anões: Eiii, essa espada em suas costas? Reconheci ela de longe, foram forjadas em nossa aldeia por nossos melhores ferreiros.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Eu ganhei de um homem chamado Enganador, você deve conhecê-lo.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Rei dos Anões: O mas é claro, ele é um grande amigo meu, dei essa espada a ele quando ele nos ajudou a lutar contra o Grannus.",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp24;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Eu vou vingá-los, acabarei com o Grannus!! ou [2] É uma bela espada vou continuar com ela se não se importa.",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp24 = entrada.nextInt();

			if (resp24 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Eu vou vingá-los, acabarei com o Grannus!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp24 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": É uma bela espada vou continuar com ela se não se importa.",
						TimeUnit.MILLISECONDS, temp_dialog);

				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp24 != 1 || resp24 != 2);

		Digita("\n\n - Doodou: Melhor irmos andando ainda temos muito caminho pela frente!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Rei dos Anões: " + nome_aventureiro
				+ " espere um pouco! Como forma de agradecimento, pegue essa roupa que encontrei no baú que você abriu! Ela é uma armadura que concede 60% de escudo contra-ataques mágicos.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro
				+ ": Muito obrigado Rei, acredito que isso vai me ajudar muito quando eu chegar em meu destino!"
				+ " Adeus!", TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n - Doodou: Melhor abrir o mapa meu jovem, não conhecemos o caminho até o Reino da Morte.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro
				+ ": Subir essa montanha foi moleza, vamos levar um dia pra descer tudo isso Doodou!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Fique tranquilo eu tive uma ideia, quando chegarmos lá embaixo você vai ver!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp25;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Lá vem você com essas ideias malucas. ou [2] Na sua última ideia nós quase caímos de cima de um Hipogrifo!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp25 = entrada.nextInt();

			if (resp25 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Lá vem você com essas ideias malucas", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp25 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Na sua última ideia nós quase caímos de cima de um Hipogrifo!",
						TimeUnit.MILLISECONDS, temp_dialog);

				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp25 != 1 || resp25 != 2);

		Digita("\n\n - Doodou: Então você vai adorar o que eu estou pensando... rsrs", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp26;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Nós devíamos ter pego mais suprimentos com o Rei dos anões. ou [2] Eu estou morrendo de fome.",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp26 = entrada.nextInt();

			if (resp26 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Nós devíamos ter pego mais suprimentos com o Rei dos anões",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;

			} else if (resp26 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Eu estou morrendo de fome.", TimeUnit.MILLISECONDS,
						temp_dialog);

				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp26 != 1 || resp26 != 2);

		Digita("\n\n - Doodou: Calma, tenho uma coisa aqui na mochila pra você, toma coma isto! É uma pílula de comida que eu seu pai criamos para os guerreiros das Grandes Guerras.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Eca isso tem gosto de terra!", TimeUnit.MILLISECONDS, temp_dialog);

		int resp27;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Ei o que você está fazendo? ou [2] Você não tem nada melhor aí pra comer não?",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp27 = entrada.nextInt();

			if (resp27 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Ei o que você está fazendo? ", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Doodou: Isso meu jovem, é uma armadilha para atrair hipogrifos!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;

			} else if (resp27 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Você não tem nada melhor aí pra comer não?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Doodou: Isso é o melhor que você poderia estar comendo!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp27 != 1 || resp27 != 2);

		Digita("\n\n - Doodou: Veja já estamos chegando no pé da montanha, acho que já posso montar isso!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Então a sua ideia é pegar o Hipogrifo de novo?", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Doodou: Se ele morder a isca, sim é exatamente isso que estou pensando!"
				+ "\n Não gosto nada da ideia de conhecermos esses Elfos, eles parecem perigosos demais e estamos quase sem tempo!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp28;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Nós poderíamos conseguir a ajuda deles para derrotar o Grannus, o que acha? ou [2] Você tem razão vamos procurar esse Hipogrifo!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp28 = entrada.nextInt();

			if (resp28 == 1) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Nós poderíamos conseguir a ajuda deles para derrotar o Grannus, o que acha?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Doodou: Você realmente acha que eles nos ajudariam? Eles poderiam ter acabado com o Grannus... pra mim eles podem ser uma ameaça!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;

			} else if (resp28 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Você tem razão vamos procurar esse Hipogrifo!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp28 != 1 || resp28 != 2);

		
		Digita("\n\n - Doodou: EI está ouvindo isso? Acho que ele está próximo!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Estou vendo-o Hipogrifo!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Lembre-se do que fizemos antes!", TimeUnit.MILLISECONDS, temp_dialog);

		int resp29;
		
		do {
			Digita("\n\n - " + nome_aventureiro + ": [1] Fazer reverência. ou [2] Montar no Hipogrifo.",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp29 = entrada.nextInt();

			if (resp29 == 1) {
				Digita("\n\n - Doodou: Muito bem " + nome_aventureiro + " você aprendeu certinho!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;

			} else if (resp29 == 2) {
				Digita("\n\n - Doodou: EII EII o que você está fazendo? Faça a reverência primeiro ou está querendo morrer?",
						TimeUnit.MILLISECONDS, temp_dialog);
       
		int resp34;
        	   Digita("\n\n - " + nome_aventureiro + ": [1] Fazer reverência.",
   					TimeUnit.MILLISECONDS, temp_dialog);
   			System.out.println("\n");
   			resp34 = entrada.nextInt();
				break;
				
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp29 != 1);

		
		Digita("\n\n - Doodou: Isso ótimo, vamos chegar assim que o sol se pôr!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Vamos lá garoto nos leve nessa direção!", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp30;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Acho que devíamos acampar a noite e nos preparar para luta. ou [2] Vamos direto ao Grannus não quero que ele escape!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp30 = entrada.nextInt();

			if (resp30 == 1) {
				Digita("\n\n - Doodou: Boa ideia " + nome_aventureiro
						+ " vamos nos esconder nas árvores até o sol nascer.", TimeUnit.MILLISECONDS, temp_dialog);
				break;

			} else if (resp30 == 2) {
				Digita("\n\n - Doodou: Tem certeza? Acho melhor você descansar para enfrentá-lo, ele é muito poderoso!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp30 != 1 || resp30 != 2);

		Digita("\n\n - " + nome_aventureiro + ": Olha Doodou tem alguma coisa brilhando no Bosque!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Deve ser o Palácio dos Elfos, esse negócio brilha mesmo em!", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp31;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Não é atoa que eles tem tantas joias. ou [2] Acho que consigo ver o Reino da Morte no horizonte!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp31 = entrada.nextInt();

			if (resp31 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Não é à toa que eles tem tantas joias", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;

			} else if (resp31 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Acho que consigo ver o Reino da Morte no horizonte",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp31 != 1 || resp31 != 2);

		Digita("\n\n - Doodou: Muito bem, já estamos chegando! Vamos garoto mais rápido!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Ei, segura garoto, vamos pousar ali.", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Doodou: Certo agora que chegamos perto do reino, tenho que te falar uma coisa.",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp32;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Espero que não seja mais uma das suas brilhantes ideias. ou [2] Nós vamos passar bastante tempo juntos ainda, quer me falar isso agora?",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp32 = entrada.nextInt();

			if (resp32 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Espero que não seja mais uma das suas brilhantes ideias",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;

			} else if (resp32 == 2) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Nós vamos passar bastante tempo juntos ainda, quer me falar isso agora?",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;

			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp32 != 1 || resp32 != 2);

		Digita("\n\n - Doodou: Escute isso não é uma piada, eu preciso que você se lembre do verdadeiro motivo de estarmos aqui, caso eu morra em batalha você precisa continuar,\n não é só pela sua irmã, mas por todo mundo. Grannus não pode continuar com os poderes do seu pai e você deve detê-lo!!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp33;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Eu não esperava por isso, eu confio em você Doodou vamos voltar juntos para casa! ou [2] Entendido, eu vou matá-lo custe o que custar!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp33 = entrada.nextInt();

			if (resp33 == 1) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Eu não esperava por isso, eu confio em você Doodou vamos voltar juntos para casa",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;

			} else if (resp33 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Entendido, eu vou matá-lo custe o que custar!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp33 != 1 || resp33 != 2);

		Digita("\n\n - Doodou: Muito bem, agora é melhor você descansar! Eu vou ficar de guarda, não estamos seguros aqui.",
				TimeUnit.MILLISECONDS, temp_dialog);

		capitulo_3(numTentativas);
		return numTentativas;
	}

//================================================================ CAPITULO 3 ==============================================================================================================================
	static int capitulo_3(int numTentativas) throws Exception {

		Scanner entrada = new Scanner(System.in);
		int numTentativas1 = numTentativas;

		Digita("\n\n  CAPÍTULO FINAL - O segredo é revelado", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n..:: 4º Dia da Jornada ::.. ", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n - Doodou: Acorde garoto, precisamos seguir em frente! Vamos descobrir como salvar sua irmã e acabar com tudo isso.",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp;
		do {
			Digita("\n\n - " + nome_aventureiro + ": [1] Vamos, estou pronto!! ou [2] Esperaaaaa, eu estou cansado!!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp = entrada.nextInt();

			if (resp == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos estou pronto!!", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Esperaaaaa, eu estou cansado!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp != 1 || resp != 2);

		if (resp == 1) {
			Digita("\n\n - Doodou: Vamos ter que entrar por trás para ele não ver a gente.", TimeUnit.MILLISECONDS,
					temp_dialog);
		} else if (resp == 2) {
			Digita("\n\n - Doodou: Essa pílula que eu te dei não te fez muito bem, vamos acorde!",
					TimeUnit.MILLISECONDS, temp_dialog);
		}

		Digita("\n\n - " + nome_aventureiro + ": Certo vamos andando!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Que estranho não há guardas e não vejo ninguém.", TimeUnit.MILLISECONDS, temp_dialog);

		int resp1;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Ele deve ser muito convencido mesmo. ou [2] Isso pode ser uma armadilha!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp1 = entrada.nextInt();

			if (resp1 == 1) {
				Digita("\n - " + nome_aventureiro + ": Ele deve ser muito convencido mesmo.", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp1 == 2) {
				Digita("\n - " + nome_aventureiro + ": Isso pode ser uma armadilha!!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.err.println("Você não digitou uma resposta valída!");
			}
		} while (resp1 != 1 || resp1 != 2);

		Digita("\n\n - Doodou: Você pode estar certo! Tenha cuidado!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Eu acho que estou vendo a entrada, vamos!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Doodou: Ei " + nome_aventureiro + " espereee!! [...] Ah droga isso não é nada bom!!!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": EU FINALMENTE ENCONTREI VOCÊ!!!!!!!!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n SINTA A FÚRIA DA MINHA ESPADA!!!!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Mas o que…!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n Você tem muita coragem criança!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: " + nome_aventureiro
				+ " não ataque sem uma estratégia, não se esqueça com que estamos lidando!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n Eles se entreolharam." + nome_aventureiro
				+ " estava carregado de lembranças, de uma luta que ficou no passado, mas ainda marcava o presente. \r\n"
				+ " A intensa magia de Grannus fazia com que eles não se enxergassem muito bem, visto que estavam a uma distância considerável. \r\n"
				+ " Estava um de frente com o outro, até que Grannus resolveu se pronunciar: ", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Grannus: Eu sabia que vocês viriam atrás de mim! mas para que? para morrer igual seu pai miserável? Se veio me matar, vai precisar muito mais que uma espada e um duende HAHAHAHAHA!!!!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp2;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Você foi covarde matando meu pai enquanto ele estava fraco! ou [2] Você vai pagar por tudo que fez cretino!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp2 = entrada.nextInt();

			if (resp2 == 1) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Você foi um covarde matando meu pai enquanto ele estava fraco!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp2 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Você vai pagar por tudo que fez cretino!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp2 != 1 || resp2 != 2);

		Digita("\n\n - Grannus: Você é aquela criança? Ah sim eu devo estar certo, eu lembro de você naquele dia!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n  No dia em que eu salvei a sua vida e o levei para casa em segurança! Eu cuidei de você enquanto seu pai não podia nem levantar da cama, de você e dos seus irmãos, fracos!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp3;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Então se lembra de mim sabe porque eu estou aqui! ou [2] Eu vim acabar com a maldição que você jogou na minha irmã!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp3 = entrada.nextInt();

			if (resp3 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Então se lembra de mim sabe porque eu estou aqui!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp3 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Eu vim acabar com a maldição que você jogou na minha irmã!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp3 != 1 || resp3 != 2);

		Digita("\n\n - Grannus: HAHAHA você sabe o que vai precisar fazer para conseguir isso não sabe?",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus ainda levado pelo feitiço lançado sobre ele, olha com desprezo e ódio para o jovem "
				+ nome_aventureiro + " enquanto Doodou busca uma estratégia para derrotar o Grannus.",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp4;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Eu vou vencê-lo custe o que custar! ou [2] Doodou o que vamos fazer?",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp4 = entrada.nextInt();

			if (resp4 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Eu vou vencê-lo custe o que custar!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp4 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Doodou o que vamos fazer?", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp4 != 1 || resp4 != 2);

		Digita("\n\n - Doodou: Aqui pegue isso e jogue na frente dele!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Certo! AAAARRRGG TOME ISSO!!!!!!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Doodou: Muito bem " + nome_aventureiro + "!! Use sua espada agora!!!!", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp5;
		do {
			Digita("\n\n - " + nome_aventureiro + ": [1] Atacar com a espada. ou [2] Esperar o ataque de Grannus.",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp5 = entrada.nextInt();

			if (resp5 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": AAAAHHH SEGURA ESSA!!!!!!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n Espera aí, cadê ele ?", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp5 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Não consigo ver nada com essa fumaça!!!!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp5 != 1 || resp5 != 2);

		Digita("\n\n - Doodou: A droga! " + nome_aventureiro + " em cima de você!!!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Grannus: CRUENTOS PASSOS", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": AAAAARRHHHH!!!!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n DOODOU ELE É MUITO FORTE!!!!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Acabou pra você criança! Você sangrará até que sua vida acabe!!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Não tão cedo Grannus, não me subestime!!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Grannus: MAS O QUE!!!?", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Essa armadura realmente foi útil!! Agora é minha vez!!!!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp6;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Você devia se arrepender enquanto pode! ou [2] Eu não vou errar dessa vez!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp6 = entrada.nextInt();

			if (resp6 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Você devia se arrepender enquanto pode!!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp6 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Eu não vou errar dessa vez!!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp6 != 1 || resp6 != 2);

		Digita("\n\n - Grannus: AAAAAAH, AHHHH TIRA ISSO DE MIM " + nome_aventureiro + "! EU NÃO AGUENTO MAIS!!!!!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": O que foi isso? Como o olho dele mudou de cor?", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Doodou: Ele está com uma magia obscura dentro dele " + nome_aventureiro
				+ " eu sinto uma força muito estranha! \n Pode ser o feitiço que o irmão do seu pai usou para possuir o corpo de Grannus antes de morrer."
				+ "\n Precisamos ajudá-lo, ele está sofrendo!!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp7;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] AAAAH EU VOU ACABAR COM A VIDA DELE!!!!!! ou [2] Como vamos ajudá-lo?",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp7 = entrada.nextInt();

			if (resp7 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": AAAAH EU VOU ACABAR COM A VIDA DELE!!!!!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Doodou: Se você matar ele, pode ser que nunca descobriremos a cura para sua irmã!",
						TimeUnit.MILLISECONDS, temp_dialog);

				int resp8;

				Digita("\n\n - " + nome_aventureiro
						+ ": [1] Você tem razão, precisamos dele vivo! ou [2] Você tem algum plano?",
						TimeUnit.MILLISECONDS, temp_dialog);
				System.out.println("\n");
				resp8 = entrada.nextInt();

				if (resp8 == 1) {
					Digita("\n\n - " + nome_aventureiro + ": Você tem razão, precisamos dele vivo!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Doodou: Eu tenho um plano, mas pode ser perigoso! SE AFASTE!", TimeUnit.MILLISECONDS,
							temp_dialog);
					break;
				} else if (resp8 == 2) {
					Digita("\n\n - " + nome_aventureiro + ": Você tem algum plano?", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Doodou: Eu tenho um plano, mas pode ser perigoso! SE AFASTE!", TimeUnit.MILLISECONDS,
							temp_dialog);
					break;
				} else {
					System.out.println("Você não digitou uma resposta valída!");
				}

			} else if (resp7 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Como vamos ajudá-lo?", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Doodou: Eu tenho um plano, mas pode ser perigoso! SE AFASTE!", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": O que você vai fazer?", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp7 != 1 || resp7 != 2);

		Digita("\n\n - Doodou: Distraia ele " + nome_aventureiro + ", vou tentar usar algo pelas costas dele!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": GRANUUS, VENHA ME PEGAR ESTOU AQUI!!! BUUH!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Doodou: É agora " + nome_aventureiro + " você vai precisa me ajudar!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Doodou: CORPUUUSS RETIREEEE!!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: AAAAAAAAAHHH!!!!", TimeUnit.MILLISECONDS, temp_dialog);

		boolean acertou = false;
		int contador = 0;
		List alternativas = new ArrayList();
		alternativas.add("2"); // resposta correta
		alternativas.add("2,5");
		alternativas.add("-2,5");
		alternativas.add("-3");
		alternativas.add("3");

		do {
			Collections.shuffle(alternativas);
			System.out.println(
					"\n\n Para retirar a magia do corpo de Grannus, podemos afirmar que o zero da função f(x) = -2x + 5 é igual a: ");
			System.out.println("");
			System.out.println("a) " + alternativas.get(0));
			System.out.println("b) " + alternativas.get(1));
			System.out.println("c) " + alternativas.get(2));
			System.out.println("d) " + alternativas.get(3));
			System.out.println("e) " + alternativas.get(4));
			System.out.println("");
			System.out.print("Escolha uma alternativa: ");
			String resposta = entrada.next();
			switch (resposta) {
			case "a":
			case "A":
				if (alternativas.get(0).equals("2,5")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "b":
			case "B":
				if (alternativas.get(1).equals("2,5")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "c":
			case "C":
				if (alternativas.get(2).equals("2,5")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "d":
			case "D":
				if (alternativas.get(3).equals("2,5")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "e":
			case "E":
				if (alternativas.get(4).equals("2,5")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			default:
				System.out.println("Escolha inválida!");
			}
		} while (!acertou & contador < numTentativas1);

		if (acertou) {
			System.err.println("Você acertou com " + contador + " tentativa!");
			final_1(numTentativas1);
			numTentativas1 = 3;
		} else {
			System.err.println("Você errou " + numTentativas1 + " vezes seguidas!");
			numTentativas1 = numTentativas1 - 1;
			if (numTentativas1 == 0) {
				Digita("\n\n\n GAME OVER!!!", TimeUnit.MILLISECONDS, temp_transicao);
				System.exit(0);
			}
			final_2(numTentativas1);
		}
		return numTentativas1;
	}

//================================================================ Final 1 ==============================================================================================================================	

	static void final_1(int numTentativas1) throws Exception {
		Scanner entrada = new Scanner(System.in);
		int numTentativas = numTentativas1;

		Digita("\n\n - Doodou: Boaaa " + nome_aventureiro + "! Agora, segure ele até o feitiço fazer efeito!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp;

		do {
			Digita("\n\n - " + nome_aventureiro + ": [1] Doodou, isso vai dar certo? ou [2] Ele pode morrer?",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp = entrada.nextInt();

			if (resp == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Doodou, isso vai dar certo?", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Ele pode morrer?", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp != 1 || resp != 2);

		Digita("\n\n - Doodou: Eu espero que dê certo e que ele não morra!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: O que você feeeez!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro
				+ " e Doodou torcem para que o efeito da poção faça com que Grannus volte a si depois de tantos anos enfeitiçado, caso contrário eles não terão escolha ao não ser matá-lo.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n  Doodou: Veja " + nome_aventureiro + " eu disse que ia dar certo!", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp1;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Grannus olhe pra mim, você sabe quem sou? ou [2] Eu acho que isso ainda não acabou!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp1 = entrada.nextInt();

			if (resp1 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Grannus olhe pra mim, você sabe quem sou? ",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp1 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Eu acho que isso ainda não acabou!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp1 != 1 || resp1 != 2);

		Digita("\n\n - Grannus: Onde… onde estou, que lugar é esse?", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Porque vocês estão aqui?", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: AAAHH É essa poção pegou ele de jeito!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Você é a criança não é? Que salvamos aquele dia! Onde está meu mestre?",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou você sabe!! ONDE ESTÁ MEU MESTRE!!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Olha cara... temos muito pra te contar.", TimeUnit.MILLISECONDS, temp_dialog);

		int resp2;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Vamos te contar tudo que precisa saber! ou [2] Você realmente não se lembra de nada?",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp2 = entrada.nextInt();

			if (resp2 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos te contar tudo que precisa saber!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Eu não entendo! Está tudo girando pra mim!", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp2 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Você realmente não se lembra de nada?", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Grannus: Eu me lembro de que... me lembro que salvamos a cidade e derrotamos o Centrion!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n  O que aconteceu depois?", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp2 != 1 || resp2 != 2);

		int resp3;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Vamos levá-lo pra casa, ainda precisamos da ajuda dele! ou [2] Doodou você acredita nele?",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp3 = entrada.nextInt();

			if (resp3 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos levá-lo pra casa, ainda precisamos da ajuda dele! ",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp3 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Doodou você acredita nele? ", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp3 != 1 || resp3 != 2);

		Digita("\n\n - Doodou: Vamos amarrá-lo eu ainda não confio nele!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Vocês ainda não me disseram o que estamos fazendo aqui!", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp4;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Amarrar Grannus e levá-lo embora. ou [2] Dizer o que ele precisa saber.",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp4 = entrada.nextInt();

			if (resp4 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Amarrar Grannus e levá-lo embora. ", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - " + nome_aventureiro
						+ ": Já disse que contaremos no caminho, agora me deixe te amarrar! ", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp4 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Dizer o que ele precisa saber.", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Nós estamos aqui por que você...", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Doodou: EI EI não conte nada a ele agora, contamos no caminho ande logo!!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Você tem razão, nosso tempo está acabando!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Tempo? Do que vocês estão falando?", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp4 != 1 || resp4 != 2);

		Digita("\n\n - Doodou: " + nome_aventureiro
				+ " vou chamar nosso amigo, se prepare e explique a ele o que precisamos fazer!", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp5;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Lá vem você com suas ideias rsrs. ou [2] HAHAHA ele vai adorar isso!!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp5 = entrada.nextInt();

			if (resp5 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Lá vem você com suas ideias rsrs. ", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else if (resp5 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": HAHAHA ele vai adorar isso!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp5 != 1 || resp5 != 2);

		Digita("\n\n - Doodou: " + nome_aventureiro
				+ ", para irmos embora vamos precisar das coordenadas! você consegue olhar no livro?",
				TimeUnit.MILLISECONDS, temp_dialog);

		boolean acertou = false;
		int contador = 0;
		List alternativas = new ArrayList();
		alternativas.add("-3,0"); // resposta correta
		alternativas.add("3,0");
		alternativas.add("2,5");
		alternativas.add("-2,5");
		alternativas.add("0,5");
		do {
			Collections.shuffle(alternativas);
			System.out.println(
					"\n\n Volte pra casa e salve sua irmã mas você vai precisar das coordenadas do vértice de uma função do segundo grau definida por f(x) = 2x2 + 10x + 12? ");
			System.out.println("");
			System.out.println("a) " + alternativas.get(0));
			System.out.println("b) " + alternativas.get(1));
			System.out.println("c) " + alternativas.get(2));
			System.out.println("d) " + alternativas.get(3));
			System.out.println("e) " + alternativas.get(4));
			System.out.println("");
			System.out.print("Escolha uma alternativa: ");
			String resposta = entrada.next();
			switch (resposta) {
			case "a":
			case "A":
				if (alternativas.get(0).equals("-3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "b":
			case "B":
				if (alternativas.get(1).equals("-3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "c":
			case "C":
				if (alternativas.get(2).equals("-3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "d":
			case "D":
				if (alternativas.get(3).equals("-3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "e":
			case "E":
				if (alternativas.get(4).equals("-3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			default:
				System.out.println("Escolha inválida!");
			}
		} while (!acertou & contador < numTentativas);

		if (acertou) {
			System.out.println("Você acertou com " + contador + " tentativa!");
			numTentativas = 3;
		} else {
			System.err.println("Você errou " + numTentativas + " vezes seguidas!");
			numTentativas = numTentativas - 1;
			if (numTentativas == 0) {
				Digita("\n\n\n GAME OVER!!!", TimeUnit.MILLISECONDS, temp_transicao);
				System.exit(0);
			} else {
				Digita("\n\n - " + nome_aventureiro
						+ ": Acho que vamos pela sorte mesmo rs. Vamos em direção a montanha!", TimeUnit.MILLISECONDS,
						temp_dialog);
			}
		}

		Digita("\n\n - " + nome_aventureiro
				+ ": Grannus vamos embora num Hipogrifo, ele é nosso amigo mas por via das dúvidas faça a reverência precisamos de você vivo! ",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: UM HIPOGRIFO?? Só quero entender o que estamos fazendo!", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp6;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Fique tranquilo, te explicaremos tudo no caminho! ou [2] Chamar Hipogrifo.",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp6 = entrada.nextInt();

			if (resp6 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Fique tranquilo, te explicaremos tudo no caminho! ",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp6 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Chamar Hipogrifo.", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp6 != 1 || resp6 != 2);

		Digita("\n\n  IIIAAARRG", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Lá vem ele!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Muito bem garoto, precisamos da sua ajuda!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Doodou: Vamos lá subam!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n\n  Enquanto o forte Hipogrifo leva-os para casa, Doodou e " + nome_aventureiro
				+ " contam tudo que Grannus precisava saber.", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n\n..:: 5º Dia da Jornada ::.. ", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n\n - Doodou: Olhem... estamos chegando!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro
				+ ": [...] então Grannus resumindo nós precisamos que você liberte minha irmã da maldição que você lançou nela, meu irmão Solveig está com ela agora tentando encontrar um jeito de libertá-la.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Santo Merlim... eu não consigo acreditar que fiz isso! Eu cuidei daquela menina como uma irmã!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Não se culpe meu amigo, nós sabemos como Centrion era poderoso!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Grannus: Eu sinto muito...", TimeUnit.MILLISECONDS, temp_dialog);

		int resp7;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Você vai poder se desculpar quando salvar a minha irmã! ou [2] Se não salvarmos ela hoje, ela morrerá à meia noite.",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp7 = entrada.nextInt();

			if (resp7 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Você vai poder se desculpar quando salvar a minha irmã! ",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp7 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Se não salvarmos ela hoje, ela morrerá à meia noite.",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp7 != 1 || resp7 != 2);

		Digita("\n\n - Doodou: Já estou vendo a casa, vamos lá garoto mais rápido!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Chegamos! Estamos em casa!", TimeUnit.MILLISECONDS, temp_dialog);

		int resp8;

		do {
			Digita("\n\n - " + nome_aventureiro + ": [1] Chamar Solveing ou [2] Entrar na casa", TimeUnit.MILLISECONDS,
					temp_dialog);

			System.out.println("\n");
			resp8 = entrada.nextInt();

			if (resp8 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Solveing chegamos!! Está em casa? ", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Solveing: Graças a Merlim vocês voltaram!!", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Estamos aqui meu querido irmão e trago boas notícias!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Vocês conseguiram?", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Olá Solveing, a quanto tempo!", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Ele ainda é o Grannus que matou nosso pai?", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Doodou: Não Solveing, nós tiramos o feitiço dele.", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp8 == 2) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Está tudo muito calmo, vamos entrar! Hipogrifo, agora você está livre, adeus meu amigo, obrigado por tudo! Vamos Grannus...",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Força Bryanna, preciso que fique forte! tentarei uma nova magia...",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Espera ai que barulho é esse?", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Graças a Merlim vocês voltaram!!", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Estamos aqui meu querido irmão e trago boas notícias!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Vocês conseguiram?", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Olá Solveing, a quanto tempo!", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Ele ainda é o Grannus que matou nosso pai?", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Doodou: Não Solveing, nós tiramos o feitiço dele.", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp8 != 1 || resp8 != 2);

		int resp9;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Como está nossa irmã? [2] Vamos logo com isso, estamos perdendo tempo!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp9 = entrada.nextInt();

			if (resp9 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Como está nossa irmã? ", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp9 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos logo com isso, estamos perdendo tempo!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp9 != 1 || resp9 != 2);

		Digita("\n\n - Solveing: Meu irmão durante esses dias todos esperando pela sua volta eu busquei em livros e mais livros, eu tentei de tudo que pudesse ajudá-la mas nada do que eu fazia dava certo.\n Até que encontrei um livro antigo de magia oculta do nosso pai...",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: E o que tinha nele??? Vamos desembucha!!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Solveing: Eu não sei se devemos falar sobre isso na presença dele!", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp10;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Pedir para Solveing revelar o que encontrou. ou [2] Ter uma conversa a sós com Solveing.",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp10 = entrada.nextInt();

			if (resp10 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Pode contar, ele veio para nos ajudar!", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Solveing: Muito bem, o livro dizia que maldições lançadas por magos poderosos só podem ser quebradas se ou quando eles morrerem!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n ... há um silêncio no ar enquanto todos pensam numa maneira de salvar Bryanna.",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Doodou: Pois bem, olha só eu não queria dizer isso mas...", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Grannus: EU ME SACRIFICO!!!", TimeUnit.MILLISECONDS, temp_dialog);

				int resp11;

				Digita("\n\n - " + nome_aventureiro
						+ ": [1] Você não precisa fazer isso! ou [2] Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
						TimeUnit.MILLISECONDS, temp_dialog);
				System.out.println("\n");
				resp11 = entrada.nextInt();

				if (resp11 == 1) {
					Digita("\n\n - " + nome_aventureiro + ": Você não precisa fazer isso!", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se a Bryanna morresse!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre! Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo...\n na verdade eu o amava muito! Eu vou tirar você dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com “ele”, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				} else if (resp11 == 2) {
					Digita("\n\n - " + nome_aventureiro
							+ ": Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se a Bryanna morresse!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre! Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo...\n na verdade eu o amava muito! Eu vou tirar você dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com “ele”, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				} else {
					System.out.println("Você não digitou uma resposta valída!");
				}

			} else if (resp10 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos conversar lá fora meu irmão!", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Solveing: Muito bem, o livro dizia que maldições lançadas por magos poderosos só podem ser quebradas se ou quando eles morrerem!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + " Então o Grannus precisa morrer para o feitiço ser revertido?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n  Solveing: É a única forma, como ele matou nosso pai eu posso entrar e matá-lo eu mesmo!",
						TimeUnit.MILLISECONDS, temp_dialog);

			} else {
				System.out.println("Você não digitou uma resposta valída!"); 
			}

			int resp12;

			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Solveig, nosso pai nos ensinou a nunca ser covarde! ou [2] Vamos entrar e contar isso a ele.",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp12 = entrada.nextInt();

			if (resp12 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Solveig, nosso pai nos ensinou a nunca ser covarde!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Você tem razão meu irmão, conhecendo o pai ele ficaria muito magoado! Vamos entrar e contar a ele tudo que eu aprendi durante esse tempo",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro
						+ ": Grannus sempre foi uma boa pessoa, tenho certeza que ele vai entender e nos ajudar da melhor forma possível, o hipogrifo que viemos só ajudam pessoas com boas intenções, caso contrário, o Grannus não teria nem chego aqui comigo! ",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Muito bem, vou contar isso a todos... o livro dizia que maldições lançadas por magos poderosos só podem ser quebradas se ou quando eles morrerem!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n ... há um silêncio no ar enquanto todos pensam numa maneira de salvar Bryanna.",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Doodou: Pois bem, olha só eu não queria dizer isso mas...", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Grannus: EU ME SACRIFICO!!!", TimeUnit.MILLISECONDS, temp_dialog);

				int resp13;

				Digita("\n\n - " + nome_aventureiro
						+ ": [1] Você não precisa fazer isso! ou [2] Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
						TimeUnit.MILLISECONDS, temp_dialog);
				System.out.println("\n");
				resp13 = entrada.nextInt();

				if (resp13 == 1) {
					Digita("\n\n - " + nome_aventureiro + ": Você não precisa fazer isso!", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se a Bryanna morresse!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre! Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo...\n na verdade eu o amava muito! Eu vou tirar você dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com “ele”, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				} else if (resp13 == 2) {
					Digita("\n\n - " + nome_aventureiro
							+ ": Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se a Bryanna morresse!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre! Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo...\n na verdade eu o amava muito! Eu vou tirar você dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com “ele”, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				} else {
					System.out.println("Você não digitou uma resposta valída!");
				}
				break;
			} else if (resp12 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos entrar e contar isso a ele.", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Solveing: Você acha que ele vai entender?", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro
						+ " Grannus sempre foi uma boa pessoa, tenho certeza que ele vai entender e nos ajudar da melhor forma possível,\n o hipogrifo que viemos só ajudam pessoas com boas intenções, caso contrário, o Grannus não teria nem chego aqui comigo! ",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Muito bem, vou contar isso a todos... o livro dizia que maldições lançadas por magos poderosos só podem ser quebradas se ou quando eles morrerem!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n ... há um silêncio no ar enquanto todos pensam numa maneira de salvar Bryanna.",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Doodou: Pois bem, olha só eu não queria dizer isso mas...", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Grannus: EU ME SACRIFICO!!!", TimeUnit.MILLISECONDS, temp_dialog);

				int resp14;

				Digita("\n\n - " + nome_aventureiro
						+ ": [1] Você não precisa fazer isso! ou [2] Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
						TimeUnit.MILLISECONDS, temp_dialog);
				System.out.println("\n");
				resp14 = entrada.nextInt();

				if (resp14 == 1) {
					Digita("\n\n - " + nome_aventureiro + ": Você não precisa fazer isso!", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se a Bryanna morresse!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre! Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo...\n na verdade eu o amava muito! Eu vou tirar você dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com “ele”, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				} else if (resp14 == 2) {
					Digita("\n\n - " + nome_aventureiro
							+ ": Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se a Bryanna morresse!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS,
							temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre! Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo...\n na verdade eu o amava muito! Eu vou tirar você dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com “ele”, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				} else {
					System.out.println("Você não digitou uma resposta valída!");
				}
				break;
			}

		} while (resp10 != 1 || resp10 != 2);

		int resp15;

		do {
			Digita("\n\n - " + nome_aventureiro + ": [1] Você falou com ela? ou [2] Está pronto? ",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp15 = entrada.nextInt();

			if (resp15 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Você falou com ela? ", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp15 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Está pronto? ", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp15 != 1 || resp15 != 2);

		Digita("\n\n - Grannus: Eu contei a ela o que fiz, somente o que ela precisava saber… estou pronto!!",
				TimeUnit.MILLISECONDS, temp_dialog);

		int resp16;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Tem alguma coisa que posso fazer por você? [2] Você pensou em como vai fazer isso? ",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp16 = entrada.nextInt();

			if (resp16 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Tem alguma coisa que posso fazer por você? ",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Não meu jovem, eu cuidarei do resto! Obrigado por me trazerem de volta para casa!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp16 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Você pensou em como vai fazer isso? ", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Grannus: Acho que sei como fazer mas preciso da ajuda do Doodou.", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp16 != 1 || resp16 != 2);

		Digita("\n\n - Grannus: Doodou você pode me ajudar com isso?", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Eu farei isso em nome dos velhos tempos!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Obrigado velho amigo!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Vamos para fora e se não se importarem peço que enterrem o meu corpo ao lado de meu mestre, não quero que lembrem de mim pelas coisas ruins que fiz!!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: Eu sei de uma poção que fará isso sem dor, posso começar?", TimeUnit.MILLISECONDS,
				temp_dialog);

		int resp17;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Você foi um grande herói Grannus, sempre lembraremos disso! ou [2] Meu pai espera por você! Adeus! ",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp17 = entrada.nextInt();

			if (resp17 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Você foi um grande herói Grannus, sempre lembraremos disso!! ",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else if (resp17 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Meu pai espera por você! Adeus!! ", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp17 != 1 || resp17 != 2);

		Digita("\n\n - Grannus: Doodou... quando quiser!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Doodou: IN PACE MORIERIS", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n  A ira de Grannus era tão grande por ter feito tanta maldade a família que mais amava, que usou uma de suas magias mais poderosas contra ele mesmo,\n desintegrando sua alma por completo dando seu último suspiro.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n  O ato de sacrifício de Grannus fez a maldição de Bryanna desaparecer e restaurar as forças da jovem, tornando-a uma poderosa feiticeira.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n  ...:::>>>FIM<<<:::...", TimeUnit.MILLISECONDS, temp_dialog);

		System.exit(0);
	}

//================================================================ Final 2 ==============================================================================================================================	

	static void final_2(int numTentativas1) throws Exception {
		Scanner entrada = new Scanner(System.in);
		int numTentativas = numTentativas1;

		Digita("\n\n - Doodou: NÃOOOOOOOO, VOCÊ ERROU!!!!!!!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: HAHAHAHAHAHA, VOCÊ CONTAVA COM A AJUDA DELE POBRE ALMA!!!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Doodou: AAAAAAAAAAAAARRRRGGG, DESCULPE " + nome_aventureiro + "!!!!!", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": NÃOOOOOO DODOUUUUUU!!!!!!!!", TimeUnit.MILLISECONDS, temp_dialog);

		int resp;
		do {
			Digita("\n\n [1] Chamar o Grannus para a briga. ou [2] Tentar salvar o Doodou", TimeUnit.MILLISECONDS,
					temp_dialog);

			System.out.println("\n");
			resp = entrada.nextInt();

			if (resp == 1) {
				Digita("\n\n - " + nome_aventureiro + ": AAAAAHHH VOCÊ VAI SE ARREPENDER!!!!!!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Grannus: Isso é o que veremos, pobre criança. Agora é a sua vez de morrer!!!!",
						TimeUnit.MILLISECONDS, temp_dialog);
              break;
			} else if (resp == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Doodoouuu, acorde, não por favor, eu preciso de você!!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Ele está morto, agora é a sua vez e depois eu acabo com todos os seres desse mundo!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp != 1 || resp != 2);

		int resp2;

		do {
			Digita("\n\n [1] Enfiar a espada no peito de Grannus. ou "
					+ "[2] Terminar o feitiço de doodou.",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp2 = entrada.nextInt();

			if (resp2 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": UUUUAAARRG TOME ISSO!!!!!!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Grannus: Eu já te disse criança, você vai precisar mais que uma espada para me vencer!!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Você tem razão! Obrigado Doodou, por ter me deixado isso!!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Ei, o que você está fazendo ?", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": ESSA É A SUA VOLTA PARA CASA!!!!!", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Grannus: AAAAAAAAAA, O QUE ESTÁ ACONTECENDO COMIGO!!!??", TimeUnit.MILLISECONDS,
						temp_dialog);
               break;
			} else if (resp2 == 2) {
				Digita("\n\n - Grannus: AAAAAAAAAA, O QUE ESTÁ ACONTECENDO COMIGO!!!??", TimeUnit.MILLISECONDS,
						temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp2 != 1 || resp2 != 2);

		Digita("\n\n - " + nome_aventureiro + ": Grannus, você se lembra de mim?", TimeUnit.MILLISECONDS,
				temp_dialog);
		Digita("\n\n - Grannus: " + nome_aventureiro + " o que está acontecendo, onde estou?",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro
				+ ": Você foi enfeitiçado pelo irmão do mestre, ficou anos em essa magia dentro de você! Agora você está livre, você está melhor?",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Estou bem melhor, aaaah o que eu fiz? O que aconteceu?", TimeUnit.MILLISECONDS,
				temp_dialog);
		int resp3;

		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Vamos embora, no caminho eu te explico! ou [2] Você machucou muita gente, quer dizer, a magia que estava dentro de você!",
					TimeUnit.MILLISECONDS, temp_dialog);

			System.out.println("\n");
			resp3 = entrada.nextInt();

			if (resp3 == 1) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Vamos embora, no caminho eu te explico!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Vamos!!", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro
						+ ": Aconteceu diversas coisas desde que a magia entrou em seu corpo, você matou o mestre e antes de ir embora amaldiçoou a Bryanna com um feitiço maligno que está destruindo-a por dentro e fora,"
						+ "\n achamos que você não estava mais vivo, porém com vários acontecimentos soubemos da sua existência e por isso viemos atrás de você,"
						+ "\n nós achamos que a única forma de salvar a Bryanna é você refazer o feitiço que a assola noite e dia!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Como assim feitiço, como eu fiz isso? Como eu vou desfazê-lo?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro
						+ ": Vamos embora desse lugar, quando chegarmos a gente estuda uma forma de salvá-la.",
						TimeUnit.MILLISECONDS, temp_dialog);
               break;
			} else if (resp3 == 2) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Você machucou muita gente, quer dizer, a magia que estava dentro de você!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Meu deus, espero que me perdoem! Será que as pessoas vão entender?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Espero que sim, isso não foi culpa sua!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Eu fiquei quanto tempo com essa magia? o que eu fiz de ruim para a família do mago?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro
						+ ": Essa magia está dentro de você a muito tempo, aconteceu diversas coisas desde que a magia entrou em seu corpo,"
						+ "\nvocê matou o mestre e antes de ir embora amaldiçoou a Bryanna com um feitiço maligno que está destruindo-a por dentro e fora,"
						+ "\nachamos que você não estava mais vivo, porém com vários acontecimentos soubemos da sua existência e por isso viemos atrás de você, "
						+ "\nnós achamos que a única forma de salvar a Bryanna é você refazer o feitiço que a assola noite e dia!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Como assim feitiço, como eu fiz isso? Como eu vou desfazê-lo?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro
						+ ": Vamos embora desse lugar, quando voltarmos para casa vamos descobrir uma forma de salvá-la, agora vamos logo!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp3 != 1 || resp3 != 2);

		int resp4;

		do {
			Digita("\n\n [1] Chamar Hipogrifo para voltar para casa", TimeUnit.MILLISECONDS, temp_dialog);
			resp4 = entrada.nextInt();
			if (resp4 != 1) {
				System.out.println("Você não digitou uma resposta valída!");
			}
		} while (resp4 != 1);

		Digita("\n\n - " + nome_aventureiro + ": Antes disso, preciso encontrar as coordenadas!", TimeUnit.MILLISECONDS,
				temp_dialog);

		System.out.println("\n");

		boolean acertou = false;
		int contador = 0;
		List alternativas = new ArrayList();
		alternativas.add("-3,0"); // resposta correta
		alternativas.add("3,0");
		alternativas.add("2,5");
		alternativas.add("-2,5");
		alternativas.add("0,5");
		do {
			Collections.shuffle(alternativas);
			System.out.println(
					"\n\n Para conseguir voltar e salvar sua irmã descubra qual é a soma das coordenadas do vértice de uma função do segundo grau definida por f(x) = 2x2 + 10x + 12?");
			System.out.println("");
			System.out.println("a) " + alternativas.get(0));
			System.out.println("b) " + alternativas.get(1));
			System.out.println("c) " + alternativas.get(2));
			System.out.println("d) " + alternativas.get(3));
			System.out.println("e) " + alternativas.get(4));
			System.out.println("");
			System.out.print("Escolha uma alternativa: ");
			String resposta = entrada.next();
			switch (resposta) {
			case "a":
			case "A":
				if (alternativas.get(0).equals("-3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "b":
			case "B":
				if (alternativas.get(1).equals("-3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "c":
			case "C":
				if (alternativas.get(2).equals("-3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "d":
			case "D":
				if (alternativas.get(3).equals("-3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			case "e":
			case "E":
				if (alternativas.get(4).equals("3,0")) {
					System.out.println("Resposta correta!");
					acertou = true;
					contador++;
				} else {
					System.out.println("Resposta incorreta!");
					contador++;
				}
				break;
			default:
				System.out.println("Escolha inválida!");
			}
		} while (!acertou & contador < numTentativas);

		if (acertou) {
			System.out.println("Você acertou com " + contador + " tentativa!");
			numTentativas = 3;
		} else {
			System.err.println("Você errou " + numTentativas + " vezes seguidas!");
			numTentativas = numTentativas - 1;
			if (numTentativas == 0) {
				Digita("\n\n\n GAME OVER!!!", TimeUnit.MILLISECONDS, temp_transicao);
				System.exit(0);
			}
			Digita("\n\n - " + nome_aventureiro + ": Acho que vamos pela sorte mesmo rs. Vamos em direção à montanha dos anões!",
					TimeUnit.MILLISECONDS, temp_dialog);
		}

		Digita("\n\n - " + nome_aventureiro
				+ ": Conheça meu grande amigo que conheci nessa jornada até aqui, esse é o hipogrifo mágico,"
				+ "\n ele pode nos levar para casa de uma forma mais rápida! Mas cuidado, para montar nele é preciso fazer uma reverência.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: O que, como? esse bixo é mágico e muito raro! Sempre tive vontade de andar em um, como devo fazer a reverência? dessa forma?",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Ouuuu ouuu, ele está me cheirando!", TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro
				+ ": Isso mesmo, parece que ele gostou de você! agora pode subir vamos embora!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n\n - " + nome_aventureiro
				+ ": [...] então Grannus resumindo nós precisamos que você liberte minha irmã da maldição que você lançou nela, "
				+ "meu irmão Solveig está com ela agora tentando encontrar um jeito de libertá-la.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n\n..:: 5º Dia da Jornada ::.. ", TimeUnit.MILLISECONDS, temp_transicao);
		Digita("\n\n\n - Grannus: Meu deus… eu não consigo acreditar que fiz isso! Eu cuidei daquela menina como uma irmã!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - " + nome_aventureiro + ": Não se culpe meu amigo, nós sabemos como Centrion era poderoso!",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Eu sinto muito...", TimeUnit.MILLISECONDS, temp_dialog);
		
		int resp5 = 0;
		do {
		
			Digita("\n\n - " + nome_aventureiro
					+ " [1] Você vai poder se desculpar quando salvar a minha irmã!! ou [2] Se não salvarmos ela hoje, ela morrerá a meia noite.",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp5 = entrada.nextInt();

			if (resp5 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Você vai poder se desculpar quando salvar a minha irmã!!",
						TimeUnit.MILLISECONDS, temp_dialog);
                 break;
			} else if (resp5 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Se não salvarmos ela hoje, ela morrerá a meia noite.",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}
			}while (resp5 != 1 || resp5 != 2);
			
			Digita("\n\n - " + nome_aventureiro + ": Já estou vendo a casa, vamos lá garoto mais rápido!!!",
					TimeUnit.MILLISECONDS, temp_dialog);
			Digita("\n\n - " + nome_aventureiro + ": Chegamos!! Estamos em casa!!",
					TimeUnit.MILLISECONDS, temp_dialog);
         int resp100;
           do {
			Digita("\n\n - " + nome_aventureiro + " [1] Chamar Solveing ou [2] Entrar na casa", TimeUnit.MILLISECONDS,
					temp_dialog);
			System.out.println("\n");
			resp100 = entrada.nextInt();

			if (resp100 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Solveing chegamos!! Está em casa?", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Solveing: Graças a Merlim vocês voltaram!!", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Estamos aqui meu querido irmão e trago boas notícias!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Vocês conseguiram?", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Olá Solveing, há quanto tempo", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Ele ainda é o Grannus que matou nosso pai ?", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Não Solveing, nós revertemos o feitiço que estava nele.",
						TimeUnit.MILLISECONDS, temp_dialog);
                     break;
			} else if (resp100 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Está tudo muito calmo, vamos entrar...", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Solveing: Força Bryanna, preciso que fique forte! tentarei uma nova magia..\n\n Espera ai que barulho é esse? \n\n Graças a Merlim vocês voltaram!!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Estamos aqui meu querido irmão e trago boas notícias!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Vocês conseguiram?", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Olá Solveing, a quanto tempo!", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Ele ainda é o Grannus que matou nosso pai?", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Não Solveing, nós revertemos o feitiço que estava nele.",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta valída!");
			}

		} while (resp100 != 1 || resp100 != 2);
         
        int respX;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Como está nossa irmã? ou [2] Vamos logo com isso, estamos perdendo tempo!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			respX = entrada.nextInt();
           
			if(respX == 1) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Como está nossa irmã?",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			}else if(respX == 2) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Vamos logo com isso, estamos perdendo tempo!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			}else {
				System.out.println("Você não digitou uma resposta valída!");
			}
			}while (respX != 1 || respX != 2);
			
			Digita("\n\n - Solveing: Meu irmão durante esses dias todos esperando pela sua volta eu busquei em livros e mais livros,"
					+ "\n eu tentei de tudo que pudesse ajudá-la mas nada do que eu fazia dava certo."
					+ "\n Até que encontrei um livro antigo de magia oculta do nosso pai...",
					TimeUnit.MILLISECONDS, temp_dialog);
			Digita("\n\n - Doodou: E o que tinha nele? Vamos desembucha!!!!", TimeUnit.MILLISECONDS, temp_dialog);
			Digita("\n\n - Solveing: Eu não sei se devemos falar sobre isso na presença dele!", TimeUnit.MILLISECONDS,
					temp_dialog);
			
			int resp6;
			do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Pedir para Solveing revelar o que encontrou. ou [2] Ter uma conversa a sós com Solveing.",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp6 = entrada.nextInt();

			if (resp6 == 1) {

				Digita("\n\n - " + nome_aventureiro + ": Pode contar, ele veio para nos ajudar!", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Solveing: Muito bem, o livro dizia que maldições lançadas por magos poderosos só podem ser quebradas se ou quando eles morrerem!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n\n ...há um silêncio no ar enquanto todos pensam numa maneira de salvar Bryanna.",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n\n - Grannus: EU ME SACRIFICO!!", TimeUnit.MILLISECONDS, temp_dialog);
				
				int resp99;
				Digita("\n\n - " + nome_aventureiro
						+ ": [1] Você não precisa fazer isso! ou [2] Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
						TimeUnit.MILLISECONDS, temp_dialog);
				System.out.println("\n");
				resp99 = entrada.nextInt();
				
				if(resp99 == 1) {
					Digita("\n\n - " + nome_aventureiro
							+ ": Você não precisa fazer isso!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se não fizesse isso!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre!"
							+ "\n Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo e na verdade eu o amava muito! "
							+ "\n Eu vou tirar você dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com isso, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n\n  Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				}else if(resp99 == 2) {
					Digita("\n\n - " + nome_aventureiro
							+ ": Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se não fizesse isso!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre! Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo� na verdade eu o amava muito! Eu vou tirar voc� dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com isso, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n\n  Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				}else {
					System.out.println("Você não digitou uma resposta valída!");
				}
					
			} else if (resp6 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Vamos conversar lá fora meu irmão!", TimeUnit.MILLISECONDS,
						temp_dialog);
				Digita("\n\n - Solveing: Muito bem, o livro dizia que maldições lançadas por magos poderosos só podem ser quebradas se ou quando eles morrerem!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro + ": Então o Grannus precisa morrer para o feitiço ser revertido?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: É a única forma, como ele matou nosso pai eu posso entrar e matá-lo eu mesmo!",
						TimeUnit.MILLISECONDS, temp_dialog);

				int resp8;
					Digita("\n\n - " + nome_aventureiro
							+ ": [1] Solveig, o pai nos ensinou a nunca ser covarde! ou [2] Vamos entrar e contar isso a ele.",
							TimeUnit.MILLISECONDS, temp_dialog);
					System.out.println("\n");
					resp8 = entrada.nextInt();
					
					if (resp8 == 1) {
						Digita("\n\n - " + nome_aventureiro
								+ ": Solveig, o pai nos ensinou a nunca ser covarde!",
								TimeUnit.MILLISECONDS, temp_dialog);
						Digita("\n\n  Solveing: Você tem razão meu irmão, conhecendo o pai ele ficaria muito magoado!"
								+ "\nVamos entrar e contar a ele tudo que eu aprendi durante esse tempo.",
								TimeUnit.MILLISECONDS, temp_dialog);
						Digita("\n\n - Solveing: Muito bem, vou contar isso a todos... o livro dizia que maldições lançadas por magos poderosos só podem ser quebradas se ou quando eles morrerem!",
								TimeUnit.MILLISECONDS, temp_dialog);
						Digita("\n\n ... há um silêncio no ar enquanto todos pensam numa maneira de salvar Bryanna.",
								TimeUnit.MILLISECONDS, temp_dialog);
						Digita("\n\n - Grannus: EU ME SACRIFICO!!!!!", TimeUnit.MILLISECONDS, temp_dialog);
					break;
						
			} else if (resp8 == 2) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Vamos entrar e contar isso a ele.",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Você acha que ele vai entender?", TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - " + nome_aventureiro
						+ ": Grannus sempre foi uma boa pessoa, tenho certeza que ele vai entender e nos ajudar da melhor forma possível,"
						+ "\no hipogrifo que viemos só ajudam pessoas com boas intenções, caso contrário,"
						+ "\no Grannus não teria nem chegado aqui comigo! ",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Solveing: Muito bem, vou contar isso a todos... o livro dizia que maldições lançadas por magos poderosos só podem ser quebradas se ou quando eles morrerem!",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n ... há um silêncio no ar enquanto todos pensam numa maneira de salvar Bryanna.",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: EU ME SACRIFICO!!!!!", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			}else{
				System.out.println("Você não digitou uma resposta valída!");
			}
				int resp98;
				Digita("\n\n - " + nome_aventureiro
						+ ": [1] Você não precisa fazer isso! ou [2] Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
						TimeUnit.MILLISECONDS, temp_dialog);
				System.out.println("\n");
				resp98 = entrada.nextInt();
				
				if(resp98 == 1) {
					Digita("\n\n - " + nome_aventureiro
							+ ": Você não precisa fazer isso!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se não fizesse isso!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre! Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo� na verdade eu o amava muito! Eu vou tirar voc� dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com isso, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n\n  Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				}else if(resp98 == 2) {
					Digita("\n\n - " + nome_aventureiro
							+ ": Eu sei que você sempre foi fiel ao meu pai, faça o que for preciso!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou fazer isso por ela e pelo meu mestre, eu nunca me perdoaria se não fizesse isso!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Eu vou me despedir dela.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Solveing: Ela está no quarto, subindo as escadas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Quem está aí? Solveing é você?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Olá Bryanna, é o Grannus, lembra de mim?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Eu era muito pequena, você era o Aprendiz do meu pai não era?",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Você o matou!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Sim Bryanna eu matei o seu pai, ele era meu mestre! Mas por favor não quero que pense assim de mim, eu não sabia o que estava fazendo� na verdade eu o amava muito! Eu vou tirar voc� dessa maldição custe o que custar!!!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Só vim aqui para te dizer uma coisa que seu pai me disse quando estava me ensinando suas magias...",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: E o que é ?", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Grannus: Proteja o mundo mágico, ele sempre estará lá quando você precisar!",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Eu nunca entendi o que ele quis dizer com isso, mas acredito que você minha criança deve ser a única capaz de desvendar os mistérios que ainda andam por esses vales e montanhas.",
							TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n  Cuide-se e adeus.", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n - Bryanna: Solveing!! Obrigada!", TimeUnit.MILLISECONDS, temp_dialog);
					Digita("\n\n\n  Apesar de triste pelo o que fez, Solveing procura a felicidade em sua atitude de salvar a garotinha que tanto amava.",
							TimeUnit.MILLISECONDS, temp_dialog);
					break;
				}else{
					System.out.println("Você não digitou uma resposta valída!");
			}
			}else{
				System.out.println("Você não digitou uma resposta valída!");
		}
		} while (resp6 != 1 || resp6 != 2);

		int resp10;
		do {
			Digita("\n\n\n - " + nome_aventureiro + ": [1] Você falou com ela? ou [2] Está pronto?",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp10 = entrada.nextInt();

			if (resp10 == 1) {
				Digita("\n\n - " + nome_aventureiro + ": Você falou com ela?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Eu contei a ela o que fiz, somente o que ela precisava saber… estou pronto!",
						TimeUnit.MILLISECONDS, temp_dialog);

				break;
			}else if (resp10 == 2) {
				Digita("\n\n - " + nome_aventureiro + ": Está pronto?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Eu contei a ela o que fiz, somente o que ela precisava saber... estou pronto!",
						TimeUnit.MILLISECONDS, temp_dialog);

				break;
			}else{
				System.out.println("Você não digitou uma resposta váida!");
			}

		} while (resp10 != 1 || resp10 != 2);

		int resp11;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Tem alguma coisa que posso fazer por você? ou [2] Você pensou em como vai fazer isso?",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp11 = entrada.nextInt();

			if (resp11 == 1) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Tem alguma coisa que posso fazer por você?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Não meu jovem, eu cuidarei do resto! Obrigado por me trazerem de volta para casa!",
						TimeUnit.MILLISECONDS, temp_dialog);

				break;
			} else if (resp11 == 2) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Você pensou em como vai fazer isso?",
						TimeUnit.MILLISECONDS, temp_dialog);
				Digita("\n\n - Grannus: Acho que sei como fazer isso sozinho!", TimeUnit.MILLISECONDS, temp_dialog);
				break;
			} else {
				System.out.println("Você não digitou uma resposta váida!");
			}

		} while (resp11 != 1 || resp11 != 2);
		
		Digita("\n\n Vamos para fora e se não se importarem peço que enterrem o meu corpo ao lado do meu mestre, não quero que lembrem de mim pelas coisas ruins que fiz!",
				TimeUnit.MILLISECONDS, temp_dialog);
		int resp12;
		do {
			Digita("\n\n - " + nome_aventureiro
					+ ": [1] Você foi um grande herói Grannus, sempre lembraremos disso! ou [2] Meu pai espera por você! Adeus!",
					TimeUnit.MILLISECONDS, temp_dialog);
			System.out.println("\n");
			resp12 = entrada.nextInt();
			
			if(resp12 == 1) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Você foi um grande herói Grannus, sempre lembraremos disso!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			}else if(resp12 == 2) {
				Digita("\n\n - " + nome_aventureiro
						+ ": Meu pai espera por você! Adeus!",
						TimeUnit.MILLISECONDS, temp_dialog);
				break;
			}else {
				System.out.println("Você não digitou uma resposta váida!");
			}
			} while (resp12 != 1 || resp12 != 2);

		Digita("\n\n - Grannus se afasta da casa e enfia seu próprio cajado em seu peito, o tempo escurece, o vento forte surge ao norte.",
				TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n A ira de Grannus era tão grande por ter feito tanta maldade a família que mais amava, que usou uma de suas magias mais poderosas contra ele mesmo,"
				+ "\n desintegrando sua alma por completo dando seu último suspiro.",
				TimeUnit.MILLISECONDS, temp_dialog);
		Digita("\n\n - Grannus: Accipit profunda spirituuuuus!!", TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n O ato de sacrifício de Grannus fez a maldição de Bryanna desaparecer e restaurar as forças da jovem, tornando-a uma poderosa feiticeira.",
				TimeUnit.MILLISECONDS, temp_dialog);

		Digita("\n\n  ...:::>>>FIM<<<:::...", TimeUnit.MILLISECONDS, temp_dialog);
		System.exit(0);
		
	}

//================================================================ FIM DO CÓDIGO ==============================================================================================================================	
	public static void Digita(String mensagem, TimeUnit unit, long tempo_mensagem) throws InterruptedException {
		for (char caractere : mensagem.toCharArray()) {
			System.out.print(caractere);
			unit.sleep(tempo_mensagem);
		}
	}
}