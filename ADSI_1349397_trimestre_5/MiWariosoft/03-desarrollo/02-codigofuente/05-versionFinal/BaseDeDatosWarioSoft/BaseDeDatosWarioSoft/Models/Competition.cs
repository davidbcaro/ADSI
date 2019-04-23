using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Competition
    {
        [Key]
        public int IdCompetition { get; set; }

        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Código")]
        public string CodeCompetition { get; set; }

        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Ruta")]
        public string RouteCompetition  { get; set; }

        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Descripción")]
        public string Description { get; set; }

     
        public int IdLearningOutcome { get; set; }
        public int IdPhase { get; set; }
        public virtual Phases Phases { get; set; }
        public virtual LearningOutcome LearningOutcome { get; set; }

        public virtual ICollection<Group> Group { get; set; }


    }
}