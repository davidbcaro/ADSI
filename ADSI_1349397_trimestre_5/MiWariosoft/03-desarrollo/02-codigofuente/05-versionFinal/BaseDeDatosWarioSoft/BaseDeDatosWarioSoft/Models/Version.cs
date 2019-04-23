using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Version
    {
        [Key]

        public int IdVersion { get; set; }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Versión")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Version_NameVersion_Index", IsUnique = true)]
        public string NameVersion { get; set; }
        public virtual ICollection<Group> Group { get; set; }
    }
}