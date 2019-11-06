# Lamda expression

- implementation of lamda expression
## Features
- override multiple methods 

```
interface HandlClickEvents {
    void onClick();

    void dbClick();
}

class Button {

    private HandlClickEvents e = null;

    void onClick(HandlClickEvents eventHandler) {
       // touch start
       // touch time
       // touch end
       onTouchEnd(e -> {
       		if (time <= 10){
       			// wait  for another touch start
       		}else {
       			dispatch eventHandler.onClick(e)
       		}
       })
    }

    void click(){
        e.onClick();
    }

}

class Main {

    public static void main(String[] args) {
        Button b = new Button();

        b.handleClickEvents(e - > {
        	onClick{
        		this.
        	}
        	
        	onDbClick{
        	
        	}
        });
        
        b.click()
        
        b.dbClick()
    }
}

```