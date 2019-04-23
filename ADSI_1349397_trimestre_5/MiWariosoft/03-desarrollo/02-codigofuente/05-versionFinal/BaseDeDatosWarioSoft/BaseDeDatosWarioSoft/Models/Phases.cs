using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Phases
    {
        [Key]
        public int IdPhase { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Fase")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Phases_name_Index", IsUnique = true)]
        public string name { get; set; }

        public virtual ICollection<Competition> Competition { get; set; }
    }
}