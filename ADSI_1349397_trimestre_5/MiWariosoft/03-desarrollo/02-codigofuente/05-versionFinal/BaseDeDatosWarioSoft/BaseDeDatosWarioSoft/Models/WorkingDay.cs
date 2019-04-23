using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class WorkingDay
{
        [Key]

        public int IdWorkingDay { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Jornada")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("WorkingDay_description_Index", IsUnique = true)]
        public string desciption { get; set; }

        public virtual ICollection<Group> Group { get; set; }
    }
}