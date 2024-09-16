import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //coisas adicionei
    private int groundLevel=380; //Nivel do chão do mundo, parte de locomoção
    private int posicaoVooPapagaio= 364;
    
    private Pirata3 piratinha;                // O jogador principal
    private boolean mapaFoiAberto;           // Flag para verificar se o mapa está aberto

    private String aperteCparaEquiparArma = "Aperte C para equipar a sua arma";
    private String aperteMparaAbrirOmapa = "Aperte M para abrir o seu mapa";
    private String aperteOparaVerAHistoria = "Aperte O para ver a Historia";
    
    
    
    
    
    
    public void prepararPirata_Papagaio(){
        //adicionando o pirata
        piratinha = new Pirata3();
        addObject(piratinha, 130, groundLevel);
        //adicionando o papagaio
        Papagaio papagaio = new Papagaio();
        addObject(papagaio, 96, posicaoVooPapagaio);
        
        
    }
    
    public void posicionarMapa(){
        //adicionando o mapa
        Mapa mapaColetavel = new Mapa();
        addObject(mapaColetavel, 1100 , groundLevel);
    }
    
    public void mostrarTextoVida(){
        showText("Vida do Pirata: 30", 250, 20);
        showText("Vida do Inimigo: 30", 550, 20);
    }
    
    public void voltarParaHistoria() {
        if(Greenfoot.isKeyDown("o")) {
            Greenfoot.setWorld(new IntroducaoHistoria());
        }
    }
    
    public void setMapaColetado(boolean coletado) {
        // Atualiza o estado do mapa coletado na pessoa
        if (piratinha != null) {
            piratinha.setMapaColetado(coletado);
        }
    }
    
    private void mostrarTeclas() {
        showText(aperteCparaEquiparArma, 170, getHeight() - 60); // Coordenadas X, Y para a primeira instrução
        showText(aperteOparaVerAHistoria, 140, getHeight() - 35); // Coordenadas X, Y para a segunda instrução

        // Verifica se o mapa foi coletado
        if (piratinha != null && piratinha.isMapaColetado()) {
            showText(aperteMparaAbrirOmapa, 155, getHeight() - 10); // Mostrar apenas se o mapa foi coletado
        }
    }
    
    @Override
    public void act() {
        // Chama o método para mostrar as instruções de teclas
        mostrarTeclas();
        
        // Chama o método para voltar à tela de introdução
        voltarParaHistoria();
    }
    
    
    //

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 500, 1); 
        mostrarTextoVida();
        
        //adicionar papagaio e piratinha
        prepararPirata_Papagaio();
        posicionarMapa();
        
        
    }

    public void atualizarVidaPirata(int vida) {
        showText("Vida do Pirata: " + vida, 250, 20);
    }

    public void atualizarVidaInimigo(int vida) {
        showText("Vida do Inimigo: " + vida, 550, 20);
    }
    
}
    

