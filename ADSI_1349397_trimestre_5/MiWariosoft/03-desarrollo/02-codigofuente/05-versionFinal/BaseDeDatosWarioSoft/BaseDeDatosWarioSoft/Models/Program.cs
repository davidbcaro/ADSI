using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Program
    {
        [Key]

        public int IdProgram{ get; set; }
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Código")]
        public string CodeProgram { get; set; }

        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Nombre del programa")]
        [Index("Program_NameProgram_Index", IsUnique = true)]
        public string NameProgram { get; set; }

        [NotMapped]
        [Display(Name = "Código-programa ")]
        public string FullName { get { return string.Format("{0} - {1} ", CodeProgram, NameProgram); } }


        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Descripción")]
        public string Description { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Estado")]
        public bool State { get; set; }
        public int IdTrainingLevel { get; set; }

        public virtual TrainingLevel trainingLevel { get; set; }
        public virtual ICollection<Group> Group { get; set; }
    }
}