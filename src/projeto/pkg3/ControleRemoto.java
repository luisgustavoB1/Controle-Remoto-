package projeto.pkg3;
public class ControleRemoto implements Controlador {
    //Atributos
    private int volume ;
    private boolean ligado;
    private boolean tocando;
    
    //Métodos Especiais 

    public ControleRemoto() {
        this.volume = 50;
        this.ligado = false;
        this.tocando = false ;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    
    

    @Override
    public void ligar() {
        this.setLigado(true);
        this.tocando = true ;
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if(this.getLigado()){
        System.out.println("------ MENU ------");
        System.out.println("Está ligado? " + this.getLigado());
        System.out.println("Está tocando? " + this.getTocando());
        System.out.print("Volume: " + this.getVolume());
        for (int i = 0 ; i <= this.getVolume(); i+=10){
            System.out.print("|");
        }
        }else {
            System.out.println("Impossivel mostar o menu com o controle desligado");
        }
    }

    @Override
    public void fecharMenu() {
        if (this.getLigado()){
        System.out.println("");
        System.out.println("Fechando Menu...");
        } else { 
            System.out.println("Não pode fechar o menu com o controle desligado");
        
        }
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume() + 1 );
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume() - 1 );
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado()&&this.getVolume() > 0){
        this.setVolume(0);
        this.tocando = false;
        }
    }

    @Override
    public void desligarMudo() {
         if (this.getLigado() && this.getVolume() == 0){
        this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())){
            this.setTocando(true);
        }
    }

    @Override
    public void pouse() {
        if (this.getLigado() && !(this.getTocando())){
            this.setTocando(false);
            
        }
    }
    
    
    
}
