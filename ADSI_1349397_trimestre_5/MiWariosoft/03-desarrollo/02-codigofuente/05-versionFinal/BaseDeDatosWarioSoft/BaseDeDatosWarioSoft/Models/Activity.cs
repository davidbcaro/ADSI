using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Activity
    {
        [Key]
        public int IdActivity { get; set; }
        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Actividad")]
        [StringLength(200, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Activity_nameActivity_Index", IsUnique = true)]
        public string nameActivity { get; set; }

        public virtual ICollection<LearningOutcome> LearningOutcome { get; set; }
    }
}