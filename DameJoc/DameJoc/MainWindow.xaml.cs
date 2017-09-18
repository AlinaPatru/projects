using DameJoc.Models;
using DameJoc.ViewModels;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace DameJoc
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        
        Piesa Previous = new Piesa();
        int Turn = 0;
        Moves MV = new Moves();
        int ok = 0;
        int Player1Score = 0;
        int Player2Score = 0;
        


        public MainWindow()
        {
            InitializeComponent();

            /*MainWindowViewModel vm = new MainWindowViewModel();
            DataContext = vm;*/
            LoadGameViewModel vm = new LoadGameViewModel();
            DataContext = vm;
            Previous = null;
           
            PlayerTurn.Content = "Red Player's turn";
            Color color = (Color)ColorConverter.ConvertFromString("#FF930707");
            PlayerTurn.Foreground = new System.Windows.Media.SolidColorBrush(color);
            PlayerTurn.Visibility = System.Windows.Visibility.Visible;

            Player1S.Text = Player1Score.ToString();
            Player2S.Text = Player2Score.ToString();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            List<List<Piesa>> list;
            /*if(Data==0)
                list = (DataContext as MainWindowViewModel).Tabla;
            else*/
                list = (DataContext as LoadGameViewModel).Tabla;

            if (Turn % 2 == 0)
            {
                
                if (Previous == null)
                {
                    Piesa aux = (Piesa)((Button)sender).DataContext;
                    if (aux.PiesaImg == null || aux.Player.Equals("Player2"))
                        return;
                    else
                        Previous = (Piesa)((Button)sender).DataContext;
                }
                else
                {
                    Piesa Curent = (Piesa)((Button)sender).DataContext;
                    
                    if (Curent.X % 2 == Curent.Y % 2)
                    {
                        Curent = null;
                        return;
                    }

                    if (Curent.X == Previous.X && Curent.Y == Previous.Y && ok == 0)
                        Previous = null;
                    else
                    {
                        if (Curent.Player != null)
                        {
                            if (Curent.X % 2 == Curent.Y % 2 || Curent.Player.Equals("Player1"))
                            {
                                Curent = null;
                                return;
                            }
                        }
                        else
                        {
                            if (Previous.Tip.Equals("piesa"))
                                Previous = MV.MovesPlayer1(Previous, Curent, list);
                            else
                                if (Previous.Tip.Equals("rege"))
                                    Previous = MV.King1(Previous, Curent, list);

                            if (Previous == null)
                            {
                                Turn++;
                                PlayerTurn.Content = "Blue Player's turn";
                                Color color = (Color)ColorConverter.ConvertFromString("#FF031D49");
                                PlayerTurn.Foreground = new System.Windows.Media.SolidColorBrush(color);
                                PlayerTurn.Visibility = System.Windows.Visibility.Visible;

                                if (MV.End(list, "Player2"))
                                {
                                    PlayerTurn.Content = "Red Player WINS";
                                    color = (Color)ColorConverter.ConvertFromString("#FF930707");
                                    PlayerTurn.Foreground = new System.Windows.Media.SolidColorBrush(color);
                                    PlayerTurn.Visibility = System.Windows.Visibility.Visible;
                                    Player1Score++;
                                    Player1S.Text = Player1Score.ToString();
                                }
                            }
                            
                        }
                    }
                }
            }
            else
            {
                if (Turn % 2 == 1)
                {

                    if (Previous == null)
                    {
                        Piesa aux = (Piesa)((Button)sender).DataContext;
                        if (aux.PiesaImg == null || aux.Player.Equals("Player1"))
                            return;
                        else
                            Previous = (Piesa)((Button)sender).DataContext;
                    }
                    else
                    {
                        Piesa Curent = (Piesa)((Button)sender).DataContext;
                        
                        if (Curent.X % 2 == Curent.Y % 2 )
                        {
                            Curent = null;
                            return;
                        }

                        if (Curent.X == Previous.X && Curent.Y == Previous.Y && ok == 0)
                            Previous = null;
                        else
                        {
                            if (Curent.Player != null)
                            {
                                if (Curent.X % 2 == Curent.Y % 2 || Curent.Player.Equals("Player2"))
                                {
                                    Curent = null;
                                    return;
                                }
                            }
                            else
                            {
                                if(Previous.Tip.Equals("piesa"))
                                    Previous = MV.MovesPlayer2(Previous, Curent, list);
                                else
                                    if (Previous.Tip.Equals("rege"))
                                        Previous = MV.King2(Previous, Curent, list);


                                if (Previous == null)
                                {
                                    Turn++;
                                    PlayerTurn.Content = "Red Player's turn";
                                    Color color = (Color)ColorConverter.ConvertFromString("#FF930707");
                                    PlayerTurn.Foreground = new System.Windows.Media.SolidColorBrush(color);
                                    PlayerTurn.Visibility = System.Windows.Visibility.Visible;

                                    if (MV.End(list, "Player1"))
                                    {
                                        PlayerTurn.Content = "Blue Player WINS";
                                        color = (Color)ColorConverter.ConvertFromString("#FF031D49");
                                        PlayerTurn.Foreground = new System.Windows.Media.SolidColorBrush(color);
                                        PlayerTurn.Visibility = System.Windows.Visibility.Visible;
                                        Player2Score++;
                                        Player2S.Text = Player2Score.ToString();
                                    }
                                }
                            }
                        }
                    }
                }
            }

               
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            PlayerTurn.Content = "Red Player's turn";
            Color color = (Color)ColorConverter.ConvertFromString("#FF930707");
            PlayerTurn.Foreground = new System.Windows.Media.SolidColorBrush(color);
            PlayerTurn.Visibility = System.Windows.Visibility.Visible;

            /*MainWindowViewModel vm = new MainWindowViewModel();
            DataContext = vm;
            List<List<Piesa>> list = (DataContext as MainWindowViewModel).Tabla;
            Data = 0;*/
            Turn = 0;
            LoadGameViewModel vm = new LoadGameViewModel();
            DataContext = vm;
            List<List<Piesa>> list = (DataContext as LoadGameViewModel).Tabla;
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    if(i%2 != j%2)
                        if (i < 3)
                            list[i][j]=new Piesa() { PiesaImg = @"/Images/piesa1.png", X = i, Y = j, Background = @"/Images/back8.png", Player = "Player1", Tip = "piesa" };
                        else if (i >= 5)
                            list[i][j]=new Piesa() { PiesaImg = @"/Images/piesa2.png", X = i, Y = j, Background = @"/Images/back8.png", Player = "Player2", Tip = "piesa" };
                        else
                            list[i][j]=new Piesa() { PiesaImg = null, X = i, Y = j, Background = @"/Images/back8.png", Player = null, Tip = null };
                    
                }
            }
        }

        private void LoadGame_Button_Click(object sender, RoutedEventArgs e)
        {
            string line = "";
            List<Piesa> list2 = new List<Piesa>();
            try
            {
                using (StreamReader sr = File.OpenText(@"D:\animation java\DameJoc\DameJoc\TextFile1.txt"))
                {
                    Turn = Int32.Parse(sr.ReadLine());
                    Player1Score = Int32.Parse(sr.ReadLine());
                    Player1S.Text = Player1Score.ToString();
                    Player2Score = Int32.Parse(sr.ReadLine());
                    Player2S.Text = Player2Score.ToString();
                    if(Turn %2==0)
                    {
                        PlayerTurn.Content = "Red Player's turn";
                        Color color = (Color)ColorConverter.ConvertFromString("#FF930707");
                        PlayerTurn.Foreground = new System.Windows.Media.SolidColorBrush(color);
                        PlayerTurn.Visibility = System.Windows.Visibility.Visible;
                    }
                    else
                    {
                        PlayerTurn.Content = "Blue Player's turn";
                        Color color = (Color)ColorConverter.ConvertFromString("#FF031D49");
                        PlayerTurn.Foreground = new System.Windows.Media.SolidColorBrush(color);
                        PlayerTurn.Visibility = System.Windows.Visibility.Visible;
                    }
                    while ((line = sr.ReadLine()) != null)
                    {
                        if (line.Trim() != "")
                        {
                            string[] tokens = line.Split(new char[] { ' ' });
                            list2.Add(new Piesa() { Background = @tokens[0], PiesaImg = @tokens[1], Player = tokens[2], X = Int32.Parse(tokens[3]), Y = Int32.Parse(tokens[4]), Tip = tokens[5] });
                        }
                    }

                }
                LoadGameViewModel vm = new LoadGameViewModel();
                DataContext = vm;
                List<List<Piesa>> list = (DataContext as LoadGameViewModel).Tabla;
                for(int i=0;i<list2.Count();i++)
                {
                    list[list2[i].X][list2[i].Y].PiesaImg = list2[i].PiesaImg;
                    list[list2[i].X][list2[i].Y].Player = list2[i].Player;
                    list[list2[i].X][list2[i].Y].Tip = list2[i].Tip;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }


        }

        private void SaveGame_Button_Click(object sender, RoutedEventArgs e)
        {
            List<List<Piesa>> list = (DataContext as LoadGameViewModel).Tabla;
            try
            {
                using (StreamWriter sw = new StreamWriter(@"D:\animation java\DameJoc\DameJoc\TextFile1.txt"))
                {
                    sw.WriteLine(Turn);
                    sw.WriteLine(Player1Score);
                    sw.WriteLine(Player2Score);
                    string linie;
                    for (int i = 0; i < 8; i++)
                    {
                        for (int j = 0; j < 8; j++)
                        {
                            if (list[i][j].PiesaImg != null)
                            {
                                linie = list[i][j].Background + " " + list[i][j].PiesaImg + " " + list[i][j].Player + " " + list[i][j].X + " " + list[i][j].Y + " " + list[i][j].Tip;
                                sw.WriteLine(linie);
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
   
    }

    
}
