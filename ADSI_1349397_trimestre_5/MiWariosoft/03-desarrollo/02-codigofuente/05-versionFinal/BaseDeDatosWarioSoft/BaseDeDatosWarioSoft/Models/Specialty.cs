using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Specialty
    {
        [Key]

        public int IdSpecialty { get; set; }
       
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Especialidad")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Specialty_Description_Index", IsUnique = true)]
        public string Description { get; set; }

        public virtual ICollection<User> User { get; set; }
    }
}