package simon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.border.BevelBorder;
import javax.swing.Timer;
import java.awt.Color;

    //@Author alexFuller Created @2017

    public class simonFrame extends javax.swing.JFrame {
        //variable/class declaration
        int patternNumber=0;
        int userScore=1;
        int listPlace=0;
        int timerPlace=0;
        Timer simonTimer = null;
        Timer resetTimer = null;
        Color glowingRed= new Color(255,70,51);
        Color glowingBlue= new Color(0,170,255);
        Color glowingYellow= new Color(255,255,0);
        Color glowingGreen= new Color(51,255,0);
        Color plainRed= new Color(150,51,51);
        Color plainBlue= new Color(0,125,150);
        Color plainYellow= new Color(150,150,0);
        Color plainGreen= new Color(51,150,0);
        randomColorGenerator randColor = new randomColorGenerator();
        LinkedList simonStorage= new LinkedList();
        BevelBorder loweredBorder= new BevelBorder(1);
        BevelBorder raisedBorder=new BevelBorder(0);
        private void patternEstablishment(){
            //sets the length of the pattern
            patternNumber++;
            //adds the color to the LinkList for the program to use
            simonStorage.add(randColor.randColor());
        }
        public simonFrame() {
            initComponents();
            //sets color of frame that diplays when game is over
            gameEndFrame.getContentPane().setBackground(Color.DARK_GRAY);
            //formats randColorClass
            randColor.formatGen("blue","red","green","yellow");
            //sets color of main game frame
            this.getContentPane().setBackground(Color.DARK_GRAY);
            //creates a new timer class that runs the animation for the user
            simonTimer = new Timer(2000, new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {

                    if (timerPlace==simonStorage.size()){
                        //stops the timer when all of the pattern has been displayed an allows the user to begin inputting
                        simonTimer.stop();
                        watchOrActionLab.setText("Repeat the Pattern!");
                        blueButton.setEnabled(true);
                        redButton.setEnabled(true);
                        yellowButton.setEnabled(true);
                        greenButton.setEnabled(true);
                        timerPlace=0;
                    }
                    else{
                        //displays the animation for the color at timerPlace
                        if (simonStorage.get(timerPlace).equals("red")){
                            redButton.setBackground(glowingRed);
                        }
                        if (simonStorage.get(timerPlace).equals("blue")){
                            blueButton.setBackground(glowingBlue);
                        }
                        if (simonStorage.get(timerPlace).equals("yellow")){
                            yellowButton.setBackground(glowingYellow);
                        }
                        if (simonStorage.get(timerPlace).equals("green")){
                            greenButton.setBackground(glowingGreen);
                        }
                        //moves timerPlace forward
                        timerPlace++;
                        //starts reset timer
                        resetTimer.start();
                    }


                }});
            //creates a new timer for reseting colors
            resetTimer = new Timer(500, new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    //resets the color back to normal after each instance of "glowing" during the animation phase
                    redButton.setBackground(plainRed);
                    blueButton.setBackground(plainBlue);
                    yellowButton.setBackground(plainYellow);
                    greenButton.setBackground(plainGreen);
                    //stops the timer after it has ran once
                    resetTimer.stop();
                }
            });

        }

        private void checkUserPattern(String buttonColor){
            if (!simonStorage.get(listPlace).equals(buttonColor)){
                //if pattern is entered incorrectly, the game ends. Prompting a frame to appear with options for the user
                gameEndFrame.setVisible(true);
                //sets the text in a label in the prompted frame to display the user score in the form of completed rounds.
                endGameLab.setText("The game is over!\n You completed "+userScore+" round(s)!");
                //disables the panels
                blueButton.setEnabled(false);
                redButton.setEnabled(false);
                yellowButton.setEnabled(false);
                greenButton.setEnabled(false);
                //aesthetic changes
                redButton.setBackground(plainRed);
                blueButton.setBackground(plainBlue);
                yellowButton.setBackground(plainYellow);
                greenButton.setBackground(plainGreen);
            }
            else{
                //runs when button has been pressed in the correct order, moves the previous if statement's boolean to the next spot in the LinkedList
                listPlace++;
            }
            if(patternNumber==listPlace){
                //detects if the round is complete, disables panels, reenables the startGameButton, adds to the user "Score"
                redButton.setBackground(plainRed);
                blueButton.setBackground(plainBlue);
                yellowButton.setBackground(plainYellow);
                greenButton.setBackground(plainGreen);
                listPlace=0;
                watchOrActionLab.setText("Good Job!");
                blueButton.setEnabled(false);
                redButton.setEnabled(false);
                yellowButton.setEnabled(false);
                greenButton.setEnabled(false);
                startGameButton.setText("Next Round");
                scoreLabel.setText("Score: "+(userScore++));
                startGameButton.setEnabled(true);
            }
        }
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            gameEndFrame = new javax.swing.JFrame();
            exitGameButton = new javax.swing.JButton();
            restartButton = new javax.swing.JButton();
            endGameLab = new javax.swing.JLabel();
            redButton = new javax.swing.JPanel();
            greenButton = new javax.swing.JPanel();
            blueButton = new javax.swing.JPanel();
            yellowButton = new javax.swing.JPanel();
            scoreLabel = new javax.swing.JLabel();
            startGameButton = new javax.swing.JButton();
            watchOrActionLab = new javax.swing.JLabel();

            gameEndFrame.setTitle("You Lost!");
            gameEndFrame.setBackground(new java.awt.Color(51, 51, 51));
            gameEndFrame.setForeground(java.awt.Color.darkGray);
            gameEndFrame.setIconImages(null);
            gameEndFrame.setMinimumSize(new java.awt.Dimension(285, 104));

            exitGameButton.setBackground(new java.awt.Color(51, 51, 51));
            exitGameButton.setForeground(new java.awt.Color(255, 255, 255));
            exitGameButton.setText("Exit");
            exitGameButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    exitGameButtonActionPerformed(evt);
                }
            });

            restartButton.setBackground(new java.awt.Color(51, 51, 51));
            restartButton.setForeground(new java.awt.Color(255, 255, 255));
            restartButton.setText("Restart");
            restartButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    restartButtonActionPerformed(evt);
                }
            });

            endGameLab.setForeground(new java.awt.Color(255, 255, 255));
            endGameLab.setText("jLabel1");

            javax.swing.GroupLayout gameEndFrameLayout = new javax.swing.GroupLayout(gameEndFrame.getContentPane());
            gameEndFrame.getContentPane().setLayout(gameEndFrameLayout);
            gameEndFrameLayout.setHorizontalGroup(
                    gameEndFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gameEndFrameLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(gameEndFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(gameEndFrameLayout.createSequentialGroup()
                                                    .addComponent(restartButton)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                                    .addComponent(exitGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(gameEndFrameLayout.createSequentialGroup()
                                                    .addComponent(endGameLab)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addContainerGap())
            );
            gameEndFrameLayout.setVerticalGroup(
                    gameEndFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameEndFrameLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(endGameLab)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                    .addGroup(gameEndFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(exitGameButton)
                                            .addComponent(restartButton))
                                    .addContainerGap())
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Simon!");
            setBackground(new java.awt.Color(51, 51, 51));
            setForeground(java.awt.Color.black);

            redButton.setBackground(new java.awt.Color(150, 51, 51));
            redButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            redButton.setEnabled(false);
            redButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    redButtonMouseClicked(evt);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    redButtonMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    redButtonMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    redButtonMousePressed(evt);
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    redButtonMouseReleased(evt);
                }
            });

            javax.swing.GroupLayout redButtonLayout = new javax.swing.GroupLayout(redButton);
            redButton.setLayout(redButtonLayout);
            redButtonLayout.setHorizontalGroup(
                    redButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
            );
            redButtonLayout.setVerticalGroup(
                    redButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
            );

            greenButton.setBackground(new java.awt.Color(51, 150, 0));
            greenButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            greenButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            greenButton.setEnabled(false);
            greenButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    greenButtonMouseClicked(evt);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    greenButtonMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    greenButtonMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    greenButtonMousePressed(evt);
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    greenButtonMouseReleased(evt);
                }
            });

            javax.swing.GroupLayout greenButtonLayout = new javax.swing.GroupLayout(greenButton);
            greenButton.setLayout(greenButtonLayout);
            greenButtonLayout.setHorizontalGroup(
                    greenButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
            );
            greenButtonLayout.setVerticalGroup(
                    greenButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
            );

            blueButton.setBackground(new java.awt.Color(0, 125, 150));
            blueButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            blueButton.setEnabled(false);
            blueButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    blueButtonMouseClicked(evt);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    blueButtonMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    blueButtonMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    blueButtonMousePressed(evt);
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    blueButtonMouseReleased(evt);
                }
            });

            javax.swing.GroupLayout blueButtonLayout = new javax.swing.GroupLayout(blueButton);
            blueButton.setLayout(blueButtonLayout);
            blueButtonLayout.setHorizontalGroup(
                    blueButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
            );
            blueButtonLayout.setVerticalGroup(
                    blueButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
            );

            yellowButton.setBackground(new java.awt.Color(150, 150, 0));
            yellowButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            yellowButton.setEnabled(false);
            yellowButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    yellowButtonMouseClicked(evt);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    yellowButtonMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    yellowButtonMouseExited(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    yellowButtonMousePressed(evt);
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    yellowButtonMouseReleased(evt);
                }
            });

            javax.swing.GroupLayout yellowButtonLayout = new javax.swing.GroupLayout(yellowButton);
            yellowButton.setLayout(yellowButtonLayout);
            yellowButtonLayout.setHorizontalGroup(
                    yellowButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
            );
            yellowButtonLayout.setVerticalGroup(
                    yellowButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 100, Short.MAX_VALUE)
            );

            scoreLabel.setForeground(new java.awt.Color(255, 255, 255));
            scoreLabel.setText("Score:");

            startGameButton.setBackground(new java.awt.Color(51, 51, 51));
            startGameButton.setForeground(new java.awt.Color(255, 255, 255));
            startGameButton.setText("Start Game");
            startGameButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    startGameButtonActionPerformed(evt);
                }
            });

            watchOrActionLab.setForeground(new java.awt.Color(255, 255, 255));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(88, 88, 88)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(109, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(watchOrActionLab)
                                    .addGap(103, 103, 103)
                                    .addComponent(scoreLabel)
                                    .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(startGameButton)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(scoreLabel)
                                                    .addGap(16, 16, 16))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(watchOrActionLab)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                    .addComponent(startGameButton)
                                    .addContainerGap())
            );

            pack();
        }// </editor-fold>

        private void blueButtonMouseClicked(java.awt.event.MouseEvent evt) {

        }

        private void redButtonMouseClicked(java.awt.event.MouseEvent evt) {

        }

        private void greenButtonMouseClicked(java.awt.event.MouseEvent evt) {

        }

        private void yellowButtonMouseClicked(java.awt.event.MouseEvent evt) {

        }

        private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
            //runs pattern establishment
            patternEstablishment();
            //disables panels during the animations
            blueButton.setEnabled(false);
            redButton.setEnabled(false);
            yellowButton.setEnabled(false);
            greenButton.setEnabled(false);
            startGameButton.setEnabled(false);
            simonTimer.start();
            watchOrActionLab.setText("Watch the pattern!");
        }

        private void redButtonMouseEntered(java.awt.event.MouseEvent evt) {
            //makes the button "glow" when the mouse enters the panel
            if (redButton.isEnabled()){
                redButton.setBackground(glowingRed);}
        }

        private void greenButtonMouseExited(java.awt.event.MouseEvent evt) {
            //removes the glowing effect when the mouse leaves the panel
            if (greenButton.isEnabled()){
                greenButton.setBackground(plainGreen);
            }
        }

        private void greenButtonMouseEntered(java.awt.event.MouseEvent evt) {
            if (greenButton.isEnabled()){
                greenButton.setBackground(glowingGreen);
            }
        }

        private void blueButtonMouseExited(java.awt.event.MouseEvent evt) {
            if (blueButton.isEnabled()){
                blueButton.setBackground(plainBlue);
            }
        }

        private void blueButtonMouseEntered(java.awt.event.MouseEvent evt) {
            if (blueButton.isEnabled()){
                blueButton.setBackground(glowingBlue);
            }
        }

        private void yellowButtonMouseExited(java.awt.event.MouseEvent evt) {
            if (yellowButton.isEnabled()){
                yellowButton.setBackground(plainYellow);
            }
        }

        private void yellowButtonMouseEntered(java.awt.event.MouseEvent evt) {
            if (yellowButton.isEnabled()){
                yellowButton.setBackground(glowingYellow);
            }
        }

        private void redButtonMouseExited(java.awt.event.MouseEvent evt) {
            if (redButton.isEnabled()){
                redButton.setBackground(plainRed);
            }
        }

        private void redButtonMousePressed(java.awt.event.MouseEvent evt) {
            //"pushes down" the button when the button is pressed

            if (redButton.isEnabled()){
                redButton.setBorder(loweredBorder);
            }
        }

        private void redButtonMouseReleased(java.awt.event.MouseEvent evt) {
            //"Pops" the button back up when mouse is released and checks for user accuracy
            if (redButton.isEnabled()){
                redButton.setBorder(raisedBorder);
                checkUserPattern("red");
            }
        }

        private void greenButtonMousePressed(java.awt.event.MouseEvent evt) {
            if (greenButton.isEnabled()){
                greenButton.setBorder(loweredBorder);
            }
        }

        private void greenButtonMouseReleased(java.awt.event.MouseEvent evt) {
            if (greenButton.isEnabled()){
                greenButton.setBorder(raisedBorder);
                checkUserPattern("green");
            }
        }

        private void blueButtonMousePressed(java.awt.event.MouseEvent evt) {
            if (blueButton.isEnabled()){
                blueButton.setBorder(loweredBorder);
            }
        }

        private void blueButtonMouseReleased(java.awt.event.MouseEvent evt) {
            if (blueButton.isEnabled()){
                blueButton.setBorder(raisedBorder);

                checkUserPattern("blue");

            }

        }

        private void yellowButtonMousePressed(java.awt.event.MouseEvent evt) {
            if (yellowButton.isEnabled()){
                yellowButton.setBorder(loweredBorder);
            }
        }

        private void yellowButtonMouseReleased(java.awt.event.MouseEvent evt) {
            if (yellowButton.isEnabled()){
                yellowButton.setBorder(raisedBorder);
                checkUserPattern("yellow");
            }
        }

        private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {
            //resets all global variables to their original state
            simonStorage.clear();
            patternNumber=0;
            userScore=1;
            listPlace=0;
            timerPlace=0;
            //sets text back to its original state
            scoreLabel.setText("Score: ");
            watchOrActionLab.setText("");
            startGameButton.setText("Start Game");
            //hides the end game frame and enables the start game button
            gameEndFrame.setVisible(false);
            startGameButton.setEnabled(true);
        }

        private void exitGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
            //exits the program
            System.exit(0);
        }

        public static void main(String args[]) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(simonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(simonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(simonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(simonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new simonFrame().setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify
        private javax.swing.JPanel blueButton;
        private javax.swing.JLabel endGameLab;
        private javax.swing.JButton exitGameButton;
        private javax.swing.JFrame gameEndFrame;
        private javax.swing.JPanel greenButton;
        private javax.swing.JPanel redButton;
        private javax.swing.JButton restartButton;
        private javax.swing.JLabel scoreLabel;
        private javax.swing.JButton startGameButton;
        private javax.swing.JLabel watchOrActionLab;
        private javax.swing.JPanel yellowButton;
        // End of variables declaration
    }


