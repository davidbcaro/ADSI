using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Environment
    {
        [Key]
        public int IdEnvironment { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Ambiente")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Environment_EnviromentNumber_Index", IsUnique = true)]
        public string EnviromentNumber { get; set; }


        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Descripción")]
        public string Description { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Estado")]
        public bool State { get; set; }

        public virtual ICollection<Shedule> Shedule { get; set; }
    }
}