using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class TrainingLevel
    {
        [Key]

        public int IdTrainingLevel { get; set; }
        
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Nivel de formación")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("TrainingLevel_Description_Index", IsUnique = true)]
        public string Description { get; set; }
        public virtual ICollection<Program> Program { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Estado")]
        public bool State { get; set; }

        
    }
}