using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.ComponentModel;

namespace DameJoc
{

    public class Piesa : INotifyPropertyChanged
    {
        private int x;
        private int y;
        private string piesaImg;
        private string background;
        private string player;
        private string tip; 

        public int X
        {
            get { return this.x; }
            set { this.x = value; NotifyPropertyChanged("X"); }
        }

        public int Y
        {
            get { return this.y; }
            set { this.y = value; NotifyPropertyChanged("Y"); }
        }

        public string PiesaImg
        {
            get { return this.piesaImg; }
            set { this.piesaImg = value; NotifyPropertyChanged("PiesaImg"); }
        }

        public string Background
        {
            get { return this.background; }
            set { this.background = value; NotifyPropertyChanged("Background"); }
        }

        public string Player
        {
            get { return this.player; }
            set { this.player = value; NotifyPropertyChanged("Player"); }
        }

        public string Tip
        {
            get { return this.tip; }
            set { this.tip = value; NotifyPropertyChanged("Tip"); }
        }

        public event PropertyChangedEventHandler PropertyChanged;
        public void NotifyPropertyChanged(string propertyName)
        {
            if (this.PropertyChanged != null)
                this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
