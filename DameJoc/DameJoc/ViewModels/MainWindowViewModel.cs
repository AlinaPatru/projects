using DameJoc.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DameJoc.ViewModels
{
    class MainWindowViewModel
    {
        public List<List<Piesa>> Tabla { get; set; }
        public MainWindowViewModel()
        {
            Tabla = Utils.Init();
        }
    }
}
