using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Linkage
    {
        [Key]

        public int IdLinkage { get; set; }
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Tipo de vinculación")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Linkage_TypeLinkage_Index", IsUnique = true)]
        public string TypeLinkage { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Horas")]
        public string Hours { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Estado")]
        public bool State { get; set; }

        public virtual ICollection<User> User { get; set; }
    }
}