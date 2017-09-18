using DameJoc.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DameJoc.ViewModels
{
    class LoadGameViewModel
    {
        public List<List<Piesa>> Tabla { get; set; }
        public LoadGameViewModel()
        {
            Tabla = LoadGame.Init();
        }
    }
}
