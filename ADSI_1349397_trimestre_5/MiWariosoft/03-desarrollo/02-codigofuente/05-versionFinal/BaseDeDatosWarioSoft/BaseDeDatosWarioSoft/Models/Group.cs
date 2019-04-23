using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Group
    {
        [Key]
        public int IdGroup { get; set; }
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Número de Ficha")]
        [Index("Group_NumberGroup_Index", IsUnique = true)]
        public string NumberGroup { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        [Display(Name = "Fecha Inicial")]
        public DateTime InitialDate { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        [Display(Name = "Fecha Final")]
        public DateTime EndDate { get; set; }

        public int IdTrimester { get; set; }
        public int IdProject { get; set; }
        public int IdCompetition { get; set; }
        public int IdVersion { get; set; }
        public int IdProgram { set; get; }
        public int IdWorkingDay { get; set; }
     

        public virtual Competition Competition { get; set; }
        public virtual Trimester Trimester { get; set; }
        public virtual WorkingDay WorkingDay { get; set; }
        public virtual Version Version { get; set; }
        public virtual Program Program { get; set; }
        public virtual Project Project { get; set; }
        
    }
}